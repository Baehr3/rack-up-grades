import javax.swing.*;

public class Leaderboard_Frame extends JFrame {

    public Leaderboard_Frame(){
        this.setSize(700,700);
        this.setTitle("TOP 10 Leaderboard");
        this.setLocationRelativeTo(null);
        String[] columns = new String[]{
                "NO.","Player Name","Points","Game Level"
        };
        JTable table = new JTable(ViewModel.getData(),columns);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(new JScrollPane(table));
        this.pack();
        this.setLayout(null);
        setResizable(false);
        this.setVisible(true);
    };
};
