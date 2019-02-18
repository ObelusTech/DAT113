import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import javax.swing.*;
import javax.swing.JFrame;

public class GUI extends JFrame {

    static ConfigurationBuilder cb = new ConfigurationBuilder();
    public static JTextArea textArea = new JTextArea(12, 93);
    private TwitterFactory tf;

    public void confBuilder() {

        cb.setOAuthConsumerKey("xhvBGmtWRHdKfsiblrNOTJZBA");
        cb.setOAuthConsumerSecret("eiR1Ll7FVCaQasr1TfvIMA2TQpX8790hnexOgDAccs9MSI6u4S");

        cb.setOAuthAccessToken("839515543103225861-VudzjtURQfGvkpOJ86zVG6iym4seoD7");
        cb.setOAuthAccessTokenSecret("ZMbyuoTDlZOk9z7XVnY9qL5DRX4nHodPCB5qZhE9aUbKR");

    }

    public GUI() {

//        Font mainFont = new Font("Times New Roman", Font.PLAIN, 10);

        confBuilder();
        tf = new TwitterFactory(cb.build());

        JButton knapp = new JButton("Hent tweets");
        JButton knapp2 = new JButton("Tweet");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem menuItem = new JMenuItem("New Tweet");
        JMenuItem menuItem1 = new JMenuItem("Exit");

        this.setSize(1150,280);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        menuBar.add(menu);
        menu.add(menuItem);
        menuBar.add(menuItem1);

        menuItem1.addActionListener(e -> System.exit(0));
        menuItem.addActionListener(e -> {
            this.dispose();
            toMainRunner();
        });

        this.setJMenuBar(menuBar);
        JPanel panel = new JPanel();
        this.add(panel);
        panel.add(textArea);
//        textArea.setFont(mainFont);
        panel.add(knapp);
        panel.add(knapp2);
        this.setVisible(true);

        knapp.addActionListener(e -> {
            try {
                getTweetToTArea();
            } catch (TwitterException e1) {
                e1.printStackTrace();
            }
        });

        knapp2.addActionListener(e -> {
            try {
                tweetAMessage();
            } catch (TwitterException e1) {
                e1.printStackTrace();
            }
        });

    }

    public void getTweetToTArea() throws TwitterException {

        Twitter twitter = tf.getInstance();

        String hashTagName = JOptionPane.showInputDialog(this, "What hashtag do you want to use?");

        Query query = new Query("#"+hashTagName);
        query.setCount(5);
        GeoLocation geoLoc = new GeoLocation(58.3405000,8.5934300);
        query.setGeoCode(geoLoc, 400.0, Query.KILOMETERS);
        QueryResult result  =  twitter.search(query);

        for (Status s:result.getTweets()) {
            textArea.replaceSelection("\n");
            textArea.replaceSelection((String.valueOf(s.getUser().getName() + ": " + s.getText())));

        }
    }

    public void tweetAMessage() throws TwitterException{

        Twitter twitter = tf.getInstance();
        twitter.updateStatus(textArea.getText());

        JOptionPane.showMessageDialog(null, "You tweeted: " + textArea.getText());
        textArea.setText(null);

    }
    public static void toMainRunner() {

        GUI g = new GUI();

        }
    }
