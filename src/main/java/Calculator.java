import jdk.dynalink.Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private Toolkit toolkit = Toolkit.getDefaultToolkit(); // os와 상호작용하면서 비동기 적으로 GUI 구현하는데 쓰는듯!
    private Image iconImg = toolkit.getImage("hyangcon.gif");

    private JTextField textInputSpace;


    public Calculator() {
        // 숫자 입력칸 설정
        setLayout(null); // 레이아웃 양식 사용여부
        textInputSpace = new JTextField(); // 숫자 입력칸
        textInputSpace.setEditable(false); // 직접 입력 금지 (버튼으로만!)
        textInputSpace.setHorizontalAlignment(JTextField.RIGHT); // 입력칸 정렬

        textInputSpace.setBounds(10, 10, 265, 50); // 입력칸 위치 및 크기설정
        textInputSpace.setBackground(Color.WHITE);
        textInputSpace.setFont(new Font("Arial", Font.BOLD, 50));

        // 버튼 영역 설정
        JPanel numButtonPanel = new JPanel(); // html 의 div 처럼 Jframe 위에 Jpanel 을 올리고 그 위에 버튼 같은 UI 를 올리는 식 = 화면요소 배치를 용이하게
        numButtonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        numButtonPanel.setBounds(10, 70, 265, 265);

        String buttonLabels[] = {"C", "÷", "x", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0"};
        JButton buttons[] = new JButton[buttonLabels.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            buttons[i].setBackground(Color.gray);
            if (buttonLabels[i].equals("C")) {
                buttons[i].setBackground(Color.red);
            }
            if (i >= 1 && i <= 3 || i == 7 || i == 11) {
                buttons[i].setBackground(Color.darkGray);
                buttons[i].setForeground(Color.white); // 폰트 컬러 지정
            }

            numButtonPanel.add(buttons[i]);
        }

        // 요소 넣어주기
        add(textInputSpace);
        add(numButtonPanel);


        setTitle("연습용 계산기");
        setIconImage(iconImg);
        setVisible(true);
        setSize(300, 380);
        setLocationRelativeTo(null); // 윈도우에서 창 위치 표시 (null이면 중앙)
        setResizable(false); // 사이즈 조절 가능한지
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을때 hide할지 dispose할지 exit할지
    }


    public static void main(String[] args) {
        new Calculator();

    }
}
