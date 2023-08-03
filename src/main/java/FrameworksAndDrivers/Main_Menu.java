package FrameworksAndDrivers;

import ApplicationBusiness.*;
import InterfaceAdapters.GamePresenter;
import InterfaceAdapters.LeaderboardPresenter;
import InterfaceAdapters.NavigatorController;
import InterfaceAdapters.ViewModel;

import javax.swing.*;
import java.awt.event.ActionListener;


public class Main_Menu extends JFrame {
    JButton i,easy,medium,hard,leader;
    JDialog leaderboard;
    public Main_Menu(String title) {
        super(title);
        this.i = new JButton("I"); //Icon will be done
        this.easy = new JButton("Easy");
        this.medium = new JButton("Medium");
        this.hard = new JButton("Hard");
        this.leader = new JButton("Leaderboard");//buttons
    }

    public void setAndAdd(JPanel menu) {
        menu.add(i);
        i.setBounds(1000,100,100,100);
        menu.add(easy);
        easy.setBounds(200,350,200,100);
        menu.add(medium);
        medium.setBounds(500,350,200,100);
        menu.add(hard);
        hard.setBounds(800,350,200,100);
        menu.add(leader);
        leader.setBounds(400,500,400,80);
    }

    public static void main(String[] args) {

        Main_Menu mainmenu = new Main_Menu("Rack Up Grade - Main Menu");
        mainmenu.setSize(1200,700);
        mainmenu.setLocationRelativeTo(null);


        ViewModel V = new ViewModel();
        InterfaceLeaderboardPresenter P = new LeaderboardPresenter(V);
        GameOutputBoundary GP = new GamePresenter(V);
        GameUseCase G = new GameUseCase("e", P, GP);
        InputBoundary IB = new InputBoundaryImpl(G);
        NavigatorController NC = new NavigatorController(IB);

        mainmenu.setUpButtonListeners(NC, V);
        JPanel menu = new JPanel();
        menu.setLayout(null);
        mainmenu.setAndAdd(menu);
        mainmenu.add(menu);
        mainmenu.setResizable(false);
        mainmenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainmenu.setVisible(true);
        menu.setVisible(true);

    }
    public void setUpButtonListeners(NavigatorController NC, ViewModel V) {
        final String fs = System.getProperty("file.separator");
        ActionListener bs = e -> {
            Object click = e.getSource();
            if(click == i) {
                JOptionPane.showMessageDialog(this,
                        "Moles living underground of Toronto" +
                                " are taking over the U of T library," +
                                "protect the library and stop moles'" +
                                "evil plan by clicking them!",
                        "Introduction",JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"UI"+fs+"Intro.png"));
            }
            if (click == easy){
                System.out.println("easy");
                EasyUI temp = new EasyUI(NC, V);
                NC.run();


//                java.util.Timer timer = new java.util.Timer();
//                TimerTask timertask = new TimerTask() {
//                    @Override
//                    public void run() {
////                        Game_Frame game_frame = new Game_Frame(V.getInfo(), NC);
//                        if (V.getInfo().get(1) != "0") {
//                            System.out.println(V.getInfo()); }
//                        else {
//                            timer.cancel();
//                        }
//                    }
//                };
//                //Slight more delay than usecase cause there is some time required for things to set up
//                timer.scheduleAtFixedRate(timertask, 3050, 1000);


            }
            if (click == medium){
                System.out.println("medium");
            }
            if (click == hard){
                System.out.println("hard");
            }
            if (click == leader){
                NC.addToLeaderboard("");
                Leaderboard_Frame leaderboard_Frame = new Leaderboard_Frame();
            }
        };
        i.addActionListener(bs);
        easy.addActionListener(bs);
        medium.addActionListener(bs);
        hard.addActionListener(bs);
        leader.addActionListener(bs);
    }

}
