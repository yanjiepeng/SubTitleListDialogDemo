# SubTitleListDialogDemo
双标题列表对话框


效果
![lVoG34.png](https://s2.ax1x.com/2019/12/27/lVoG34.png)


使用方法参考：
```
private void showMyDialog() {

        final ArrayList<String> list = new ArrayList<>();
        list.add("Andy");
        list.add("Apure");
        list.add("Arron");
        list.add("Burks");

        SubTitleListDialog.Builder builder = new SubTitleListDialog.Builder(this);
        builder.setTitle("Tips");
        builder.setSubTitle("Select person");
        builder.setItems(list);
        builder.setSubmitButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setOnListItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "Click "+ list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();


    }

```
