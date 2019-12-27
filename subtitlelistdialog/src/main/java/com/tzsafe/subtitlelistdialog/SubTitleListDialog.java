package com.tzsafe.subtitlelistdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class SubTitleListDialog extends Dialog {


    public SubTitleListDialog(@NonNull Context context) {
        super(context);
    }

    public SubTitleListDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }


    public static class Builder {

        private Context context;
        private String title = "";
        private String subTitle = "";
        private ArrayList<String> items;
        private String submitButtonText;
        private DialogInterface.OnClickListener submitButtonClickListener;
        private AdapterView.OnItemClickListener listItemClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Set the Dialog title from resource
         *
         * @param
         * @return
         */
        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setSubTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        /**
         * Set the Dialog title from resource
         *
         * @param
         * @return
         */
        public Builder setSubTitle(int subTitle) {
            this.subTitle = (String) context.getText(subTitle);
            return this;
        }

        public void setItems(ArrayList<String> items) {
            this.items = items;
        }

        /**
         * Set the submit button resource and it's listener
         *
         * @param submitButtonText
         * @return
         */
        public Builder setSubmitButton(int submitButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.submitButtonText = (String) context
                    .getText(submitButtonText);
            this.submitButtonClickListener = listener;
            return this;
        }


        public Builder setOnListItemClickListener (AdapterView.OnItemClickListener listItemClickListener) {

            this.listItemClickListener = listItemClickListener;
            return this;
        }


        /**
         * Set the submit button resource and it's listener
         *
         * @param submitButtonText
         * @return
         */
        public Builder setSubmitButton(String submitButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.submitButtonText = submitButtonText;
            this.submitButtonClickListener = listener;
            return this;
        }


        public SubTitleListDialog create() {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final SubTitleListDialog dialog = new SubTitleListDialog(context, R.style.Dialog);

            View layout = inflater.inflate(R.layout.dialog_layout, null);

            dialog.addContentView(layout, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            //SET THE DIALOG TITLE
            ((TextView) layout.findViewById(R.id.title)).setText(this.title);
            //SET THE DIALOG SUBTITLE
            ((TextView) layout.findViewById(R.id.subTitle)).setText(this.subTitle);

            //SET THE SubButton text
            if (this.submitButtonText != null) {

                ((Button) layout.findViewById(R.id.btnSubmit))
                        .setText(submitButtonText);

                if (submitButtonClickListener != null) {

                    ((Button) layout.findViewById(R.id.btnSubmit)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            submitButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        }
                    });

                } else {
                    //no submit button
                    // if no submit button just set the visibility to GONE
                    layout.findViewById(R.id.btnSubmit).setVisibility(
                            View.GONE);
                }

            }

            //set Items
            if (items != null) {
                ListView listView = layout.findViewById(R.id.listview);
                listView.setAdapter(new ItemAdapter(context, items));

                if (listItemClickListener != null) {
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            listItemClickListener.onItemClick(adapterView, view, i, l);
                        }
                    });
                }
            } else {


            }
            dialog.setContentView(layout);

            return dialog;

        }
    }

}
