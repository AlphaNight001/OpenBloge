import {Switch, Button, Select, Row, Col, Menu, Submenu, MenuItem, MenuItemGroup, Input, Option, Table, TableColumn, Form, FormItem, MessageBox, Notification, Popover, Tag, Drawer, RadioGroup, Radio, Message, Timeline, TimelineItem, Card, Divider } from 'element-ui';

export default {
  install(Vue) {
    Vue.component(Switch.name,Switch)
    Vue.component(Button.name, Button);
    Vue.component(Select.name, Select);
    Vue.component(Row.name, Row);
    Vue.component(Col.name, Col);
    Vue.component(Menu.name, Menu);
    Vue.component(Submenu.name, Submenu);
    Vue.component(MenuItem.name, MenuItem);
    Vue.component(MenuItemGroup.name, MenuItemGroup);
    Vue.component(Input.name, Input);
    Vue.component(Option.name, Option);
    Vue.component(Table.name, Table);
    Vue.component(TableColumn.name, TableColumn);
    Vue.component(Form.name, Form);
    Vue.component(FormItem.name, FormItem);
    Vue.component(Popover.name, Popover);
    Vue.component(Tag.name, Tag);
    Vue.component(Drawer.name, Drawer);
    Vue.component(RadioGroup.name, RadioGroup);
    Vue.component(Radio.name, Radio);
    Vue.component(Timeline.name, Timeline);
    Vue.component(TimelineItem.name, TimelineItem);
    Vue.component(Card.name, Card);
    Vue.component(Divider.name, Divider);
    
    Vue.prototype.$message = Message;
    Vue.prototype.$notify = Notification;
    Vue.prototype.$msgbox = MessageBox;
    Vue.prototype.$alert = MessageBox.alert;
    Vue.prototype.$confirm = MessageBox.confirm;
    Vue.prototype.$prompt = MessageBox.prompt;
  },
};