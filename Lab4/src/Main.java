import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.Timer;
import java.util.TimerTask;




class Handler  implements ActionListener
{

    boolean flag = true;
    JButton l;
    JLabel t;
    public Integer i;

    public Handler (JButton ll, JLabel tt, int ii)
    { l = ll; t = tt; i = ii;}

    public void actionPerformed(ActionEvent e)
    {

        flag = ! flag;
        i += 1;
        String str1 = Integer.toString(i);


        l.setText(flag?"Клик":"Клак");
        t.setText(str1);

    }
    public Number getCounter(){
        return i;
    }
}


public class Main {


    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JLabel jLabel = new JLabel();
        JLabel res = new JLabel();
        res.setText("Кликай, кликай");
        JButton l1 = new JButton("Начнём?");
        JLabel tf = new JLabel();

        int i = 0;
        Handler h1 = new Handler(l1,tf,i);

        l1.addActionListener(h1);

        p.add(l1);

        tf.setBounds(150,100,275,70);
        p.add(tf);
        p.add(jLabel);
        p.add(res);



        f.setSize(500, 300);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            int tim = 30;

            public void run() {
                jLabel.setText("Времени осталось: " + tim);
                tim--;


                if (tim < 0) {
                    timer.cancel();
                    jLabel.setText("Время вышло!");
                    res.setText("Результат: " + h1.getCounter());
                }

            }

        }, 0, 1000);




    }

}

