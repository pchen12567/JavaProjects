package com.demo02;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/* JFrame – java的GUI程序的基本思路是以JFrame为基础，它是屏幕上window的对象，能够最大化、最小化、关闭。
 * JPanel – Java图形用户界面(GUI)工具包swing中的面板容器类，包含在javax.swing 包中，可以进行嵌套，
 * 功能是对窗体中具有相同逻辑功能的组件进行组合，是一种轻量级容器，可以加入到JFrame窗体中。
 * JLabel – JLabel 对象可以显示文本、图像或同时显示二者。可以通过设置垂直和水平对齐方式，指定标签显示区中标签内容在何处对齐。
 * 默认情况下，标签在其显示区内垂直居中对齐。默认情况下，只显示文本的标签是开始边对齐；而只显示图像的标签则水平居中对齐。
 * JTextField –一个轻量级组件，它允许编辑单行文本。
 * JPasswordField – 允许我们输入了一行字像输入框，但隐藏星号(*) 或点创建密码(密码)
 * JButton – JButton 类的实例。用于创建按钮类似实例中的 "Login"。
 */


public class LoginSwing {

    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Login Example");
        // 设置 frame 尺寸
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板panel实例，这个类似于 HTML 的 div 标签
         * 可以创建多个面板 panel 并在 JFrame 中指定位置
         * 面板 panel 中可以添加文本字段 text，按钮 button 及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);

        // 调用自定义的方法并添加组件到面板
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    public static void placeComponents(JPanel panel) {
        // 设置布局为null
        panel.setLayout(null);

        // 创建 JLabel 实例 用户名标签
        JLabel userLabel = new JLabel("User:");
        /* 定义组件位置
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // 创建文本域实例用于用户输入
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // 创建 JLabel 实例 密码标签
        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // 创建密码的文本输入域
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // 创建遗忘密码按钮
        JButton forgetLabel = new JButton("forget password");
        forgetLabel.setBounds(160, 80, 160, 25);
        panel.add(forgetLabel);

    }

}
