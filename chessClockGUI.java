package chessclock;

//@author james

//Import classes.
import java.awt.Color;
import javax.swing.SwingWorker;
import java.awt.event.*;
import java.awt.*;

public class chessClockGUI extends javax.swing.JFrame {

    //Creates new form chessClockGUI
    public chessClockGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

		mainPanel = new javax.swing.JPanel(new java.awt.CardLayout());
		panel1 = new javax.swing.JPanel();
		panel2 = new javax.swing.JPanel();
		panel3 = new javax.swing.JPanel();
        titleLable = new javax.swing.JLabel();
        hourSlider = new javax.swing.JSlider();
        minuteSlider = new javax.swing.JSlider();
        secondSlider = new javax.swing.JSlider();
        readyButton = new javax.swing.JButton();
        hourNote = new javax.swing.JLabel();
        minuteNote = new javax.swing.JLabel();
        secondNote = new javax.swing.JLabel();
        hourShow = new javax.swing.JLabel();
        minuteShow = new javax.swing.JLabel();
        secondShow = new javax.swing.JLabel();
		
		
        
        p1TimerLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        p2TimerLabel = new javax.swing.JLabel();
        doneButton = new javax.swing.JButton();
        activePlayerLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
		
		p1Win = new javax.swing.JLabel();
        p2Win = new javax.swing.JLabel();

		//For the main window, I guess. Does it ever mention the main window?
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess Clock");

        titleLable.setFont(new java.awt.Font("Ubuntu", 0, 36)); 
        titleLable.setBounds(90, 40, 688, 43);
        titleLable.setText("How long would you like your game to be?");
        panel1.add(titleLable);

        hourSlider.setMaximum(60);
        hourSlider.setValue(0);
        hourSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hourSliderStateChanged(evt);
            }
        });
        hourSlider.setBounds(50, 170, 204, 44);
        panel1.add(hourSlider);

        minuteSlider.setMaximum(60);
        minuteSlider.setValue(0);
        minuteSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minuteSliderStateChanged(evt);
            }
        });
        minuteSlider.setBounds(320, 170, 204, 44);
        panel1.add(minuteSlider);

        secondSlider.setMaximum(60);
        secondSlider.setValue(0);
        secondSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                secondSliderStateChanged(evt);
            }
        });
        secondSlider.setBounds(600, 170, 204, 44);
        panel1.add(secondSlider);

        readyButton.setText("Ready");
        readyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyButtonActionPerformed(evt);
            }
        });
        readyButton.setBounds(410, 260, 80, 29);
        panel1.add(readyButton);

        hourNote.setText("Hours");
        hourNote.setBounds(130, 150, 42, 17);
        panel1.add(hourNote);

        minuteNote.setText("Minutes");
        minuteNote.setBounds(390, 160, 56, 17);
        panel1.add(minuteNote);

        secondNote.setText("Seconds");
        secondNote.setBounds(680, 160, 59, 17);
        panel1.add(secondNote);

        hourShow.setText("0");
        hourShow.setBounds(130, 230, 40, 17);
        panel1.add(hourShow);

        minuteShow.setText("0");
        minuteShow.setBounds(420, 220, 40, 17);
        panel1.add(minuteShow);

        secondShow.setText("0");
        secondShow.setBounds(710, 220, 40, 17);
        panel1.add(secondShow);

		//The first "card"
        panel1.setBounds(0, 10, 960, 290);
		
		//The "card holder"
        mainPanel.add(panel1, "panel1");
		mainPanel.setBounds(0, 0, 960, 290);
		mainPanel.add(panel2, "panel2");
		mainPanel.add(panel3, "panel3");

		
		
		
		
		
		
		
		
		
		
        panel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel2KeyPressed(evt);
            }
        });

        p1TimerLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        p1TimerLabel.setText("jLabel1");

        startButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        startButton.setText("Start!");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        p2TimerLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        p2TimerLabel.setText("jLabel3");

        doneButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        p1Win.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        p1Win.setText("Player 1 wins!");

        p2Win.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        p2Win.setText("Player 2 wins!");

        activePlayerLabel.setBackground(new java.awt.Color(254, 254, 254));
        activePlayerLabel.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        jLabel1.setText("Player 1");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        jLabel2.setText("Player 2");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        jLabel3.setText("Press \"space\" to switch players.");
        jLabel3.setToolTipText("");

        

        pack();
		add(mainPanel);
		this.setBounds(0, 0, 960, 290);
    }
	
//The listener for the button that sets the time for the game.
    private void readyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int hour1;
        int minute1;
        hour = hourSlider.getValue();
        minute = minuteSlider.getValue();
        second = secondSlider.getValue();
        switchUI(2,1);
        hour1 = hour/2;
        if((hour1*2)<hour){minute=(minute+30); hour = hour - 1;}
        if(minute >= 60){hour = hour + 1; minute = minute - 60;}
        if((hour1*2)<hour){minute=(minute+30); hour = hour - 1;}
        hour = hour/2; minute1 = minute/2;
        if((minute1*2)<minute){second=(second+30); minute = minute - 1;}
        if(second >= 60){minute = minute + 1; second = second - 60;}
        if((minute1*2)<minute){second=(second+30); minute = minute - 1;}
        minute = minute/2; second = second/2;
        p1TimerLabel.setText(Integer.toString(hour)+":"+Integer.toString(minute)+":"+Integer.toString(second)+".0"); 
        p2TimerLabel.setText(Integer.toString(hour)+":"+Integer.toString(minute)+":"+Integer.toString(second)+".0");
    }
	
//Displays state of 'hour'.
    private void hourSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        String temp;
        temp = Integer.toString(hourSlider.getValue());
        hourShow.setText(temp);
    }
	
//Displays changed state of 'minute'.
    private void minuteSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        String temp;
        temp = Integer.toString(minuteSlider.getValue());
        minuteShow.setText(temp);
    }
	
//Displays changed state of 'second'.
    private void secondSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        String temp;
        temp = Integer.toString(secondSlider.getValue());
        secondShow.setText(temp);
    }
	
//The listener for the button that starts the initializes and starts the clock.
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clock1.init();
        switchUI(2,2);
        clock1.execute();
        panel2.requestFocusInWindow();
    }

//The listener for the "Done" button.
    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(1);
    }

    private void panel2KeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == 32 && clock1.paused  == false){clock1.switchPlayers();}
        else if(evt.getKeyCode() == 80){clock1.pauseAlt();}
        else if (evt.getKeyCode() == 27){System.exit(1);}
        //Grabs KeyCode of pressed key.
		//System.out.println(evt.getKeyCode());
    }
        
    
    //Some initial variables.
    int hour;
    int minute;
    int second;
    boolean done;
    boolean winner;
    clock clock1 = new clock();
    
	//Changes which elements of the GUI are visible. 1,1: init; 2,1: 2nd screen; 2,2: game start
    public void switchUI(int ui, int phase) {
        if(ui == 1 && phase == 1) {
            mainPanel.show(mainPanel, "panel1");
        }
        else if (ui == 1 && phase == 2){}
        else if (ui == 2 && phase == 1){
            mainpanel.show(mainPanel, "panel2");
        }
        else if (ui == 2 && phase == 2){
            startButton.setVisible(false);
        }
		else if (ui == 3 && phase == 1){
			mainPanel.show(mainPanel, "panel3");
		}
    }
    
    //A timer that runs in a background thread.
    public class clock extends SwingWorker <Void, Integer> {
        boolean p1Active; boolean paused = false;
        int p1H; int p1M; int p1S; int p1DS; int p1CS;
        int p2H; int p2M; int p2S; int p2DS; int p2CS;
        long time1; long time2; int time3;
        
        public void init() {
            p1H = hour; p1M = minute; p1S = second;
            p2H = hour; p2M = minute; p2S = second;
            p1DS = 10; p1CS = 10;
            p2DS = 10; p2CS = 10;
            p1Active = true;
            time2 = 0; time3 = 0;
            done = false;
            paused = false;
        }
        //Switch which player's clock will run.
        public void switchPlayers(){
            if(p1Active){p1Active = false; activePlayerLabel.setBackground(Color.black);
            }
            else if(!p1Active){p1Active = true; activePlayerLabel.setBackground(Color.white);}
        }
        //Pause method.
        public void pauseAlt() {
            if(paused){paused = false;}
            else if(!paused){paused = true;}
        }
        //End of game method.
        public void gameEnd() {
            if(p1Active){
                p2Win.setVisible(true);
            }
            else if(!p1Active){
                p1Win.setVisible(true);
            }
        }
        //The main timer method, which runs in a background thread.
        @Override
        public Void doInBackground (){
            while(!done){
                if(p1Active && paused == false){
                    time1 = System.currentTimeMillis();
                    while(time2<(time1+10)){
                        time2 = System.currentTimeMillis();
                    }
                    if(p1CS > 0){p1CS -= 1;}
                    else if(p1DS > 0){p1DS -= 1; p1CS = 9;}
                    else if(p1S > 0){p1S -= 1; p1DS = 9; p1CS = 9;}
                    else if(p1M > 0){p1M -= 1; p1S = 59; p1DS = 9; p1CS = 9;}
                    else if(p1H > 0){p1H -= 1; p1M = 59; p1S = 59; p1DS = 9; p1CS = 9;}
                    else {done = true; /*P2 WINS!!!*/}
                    p1TimerLabel.setText(Integer.toString(p1H)+":"+Integer.toString(p1M)+":"+Integer.toString(p1S)+"."+(Integer.toString(p1DS)));
                }
                else if(!p1Active && paused == false){
                    time1 = System.currentTimeMillis();
                    while(time2<(time1+10)){
                        time2 = System.currentTimeMillis();
                    }
                    if(p2CS > 0){p2CS -= 1;}
                    else if(p2DS > 0){p2DS -= 1; p2CS = 9;}
                    else if(p2S > 0){p2S -= 1; p2DS = 9; p2CS = 9;}
                    else if(p2M > 0){p2M -= 1; p2S = 59; p2DS = 9; p2CS = 9;}
                    else if(p2H > 0){p2H -= 1; p2M = 59; p2S = 59; p2DS = 9; p2CS = 9;}
                    else {done = true; /*P1 WINS!!!*/}
                    p2TimerLabel.setText(Integer.toString(p2H)+":"+Integer.toString(p2M)+":"+Integer.toString(p2S)+"."+(Integer.toString(p2DS)));
                }
            }
            gameEnd();
        return null;
        }
    }
    
    
    //@param args the command line arguments
    public static void main(String args[]) {
        //Set the Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chessClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chessClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chessClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chessClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chessClockGUI().setVisible(true);
            }
        });
    }
    // Variables declaration
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel panel1;
	private javax.swing.JPanel panel2;
	private javax.swing.JPanel panel3;
    private javax.swing.JLabel activePlayerLabel;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel hourNote;
    private javax.swing.JLabel hourShow;
    private javax.swing.JSlider hourSlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel minuteNote;
    private javax.swing.JLabel minuteShow;
    private javax.swing.JSlider minuteSlider;
    private javax.swing.JLabel p1TimerLabel;
    private javax.swing.JLabel p1Win;
    private javax.swing.JLabel p2TimerLabel;
    private javax.swing.JLabel p2Win;
    private javax.swing.JButton readyButton;
    private javax.swing.JLabel secondNote;
    private javax.swing.JLabel secondShow;
    private javax.swing.JSlider secondSlider;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel titleLable;
    // End of variables declaration
}
