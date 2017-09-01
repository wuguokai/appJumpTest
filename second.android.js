import React, { Component } from 'react';
import { AppRegistry, Text, TouchableHighlight } from 'react-native';
import { Linking, ToastAndroid } from 'react-native';

export default class Second extends Component {
    constructor(props) {
        super(props);
        this.state = {}
        this.press = this.press.bind(this);
    }

    press(){
        NativeModules.ToastModule.show("test");
    }

    render() {
        return (
                <Text>SecondApp</Text>
                <TouchableHighlight
                    onPress={this.press}
                >
                    <Text>Button</Text>
                </TouchableHighlight>
        );
    }
}   

// 注意，这里用引号括起来的'HelloWorldApp'必须和你init创建的项目名一致
AppRegistry.registerComponent('Second', () => Second);