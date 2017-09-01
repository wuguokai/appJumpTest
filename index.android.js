import React, { Component } from 'react';
import { AppRegistry, Text, TouchableHighlight } from 'react-native';
import { Linking, ToastAndroid } from 'react-native';
import { NativeModules } from 'react-native';

export default class JumpTestApp extends Component {
    constructor(props) {
    super(props);
    this.state = {}
    this.press = this.press.bind(this);
  }

    /*Jump(){
        Linking.canOpenURL('weixin://').then(supported => { // weixin://  alipay://
            if (supported) {
                Linking.openURL('weixin://');
            } else {
                toastShort(`请先安装XXX`);
           }
       });
    }*/
    press(){
        NativeModules.ToastModule.show("test");
    }

    render() {
    return (
        <TouchableHighlight
            onPress={this.press}
        >
            <Text>Button</Text>
        </TouchableHighlight>
    );
    }
}

// 注意，这里用引号括起来的'HelloWorldApp'必须和你init创建的项目名一致
AppRegistry.registerComponent('JumpTest', () => JumpTestApp);