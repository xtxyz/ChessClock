package chessclock;

//@author james

//Import classes.
import java.awt.Color;
import javax.swing.SwingWorker;
import java.awt.event.*;
import java.awt.*;
import java.awt.GridBagLayout;
import javax.swing.LayoutStyle;

public class chessClockGUI extends javax.swing.JFrame {

    //Creates new form chessClockGUI
    public chessClockGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

		//The main display panel
		mainPanel = new javax.swing.JPanel(mpLayout = new java.awt.CardLayout());
		
		//The display "cards".
		panel1 = new javax.swing.JPanel();
		panel2 = new javax.swing.JPanel();
		panel3 = new javax.swing.JPanel();
		
		GridBagLayout p1Layout = new java.awt.GridBagLayout();
		panel1.setLayout(p1Layout);
		GridBagConstraints p1c = new java.awt.GridBagConstraints();
		GridBagLayout p2Layout = new java.awt.GridBagLayout();
		panel2.setLayout(p2Layout);
		GridBagConstraints p2c = new java.awt.GridBagConstraints();
		GridBagLayout p3Layout = new java.awt.GridBagLayout();
		panel3.setLayout(p3Layout);
		GridBagConstraints p3c = new java.awt.GridBagConstraints();
		
		//The elements for the first panel.
        titleLable = new javax.swing.JLabel();
        hourSlider = new javax.swing.JSlider();
        minuteSlider = new javax.swing.JSlider();
        secondSlider = new javax.swing.JSlider();
        hourNote = new javax.swing.JLabel();
        minuteNote = new javax.swing.JLabel();
        secondNote = new javax.swing.JLabel();
        hourShow = new javax.swing.JLabel();
        minuteShow = new javax.swing.JLabel();
        secondShow = new javax.swing.JLabel();
		readyButton = new javax.swing.JButton();
		
		//and it's layout
		p1c.anchor = GridBagConstraints.CENTER;
		p1c.weightx = 1;
		p1c.weighty = 1;
		p1c.gridx = 0;
		p1c.gridy = 1;
		
		p1Layout.addLayoutComponent(hourNote, p1c);
		
		p1c.gridy = 2;
		p1Layout.addLayoutComponent(hourSlider, p1c);
		
		p1c.gridy = 3;
		p1Layout.addLayoutComponent(hourShow, p1c);
		
		p1c.gridx = 0;
		p1c.gridy = 0;
		p1c.gridwidth = 3;
		p1Layout.addLayoutComponent(titleLable, p1c);
		
		p1c.gridwidth = 1;
		p1c.gridx = 1;
		p1c.gridy = 1;
		p1Layout.addLayoutComponent(minuteNote, p1c);
		
		p1c.gridx = 1;
		p1c.gridy = 2;
		p1Layout.addLayoutComponent(minuteSlider, p1c);
		
		p1c.gridx = 1;
		p1c.gridy = 3;
		p1Layout.addLayoutComponent(minuteShow, p1c);
		
		p1c.gridx = 1;
		p1c.gridy = 4;
		p1Layout.addLayoutComponent(readyButton, p1c);
		
		p1c.gridx = 2;
		p1c.gridy = 1;
		p1Layout.addLayoutComponent(secondNote, p1c);
		
		p1c.gridx = 2;
		p1c.gridy = 2;
		p1Layout.addLayoutComponent(secondSlider, p1c);
		
		p1c.gridx = 2;
		p1c.gridy = 3;
		p1Layout.addLayoutComponent(secondShow, p1c);
		
		
		
		
		//The elements for the second panel.
        p1TimerLabel = new javax.swing.JLabel();
        p2TimerLabel = new javax.swing.JLabel();
		startButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        activePlayerLabel = new javax.swing.JLabel();
        p1Label = new javax.swing.JLabel();
        p2Label = new javax.swing.JLabel();
        instructionLabel = new javax.swing.JLabel();
		
		//and it's layout
		p2c.anchor = GridBagConstraints.CENTER;
		p2c.weightx = 1;
		p2c.weighty = 1;
		p2c.gridx = 0;
		p2c.gridy = 1;
		
		p2Layout.addLayoutComponent(p1Label, p2c);
		
		p2c.gridx = 0;
		p2c.gridy = 2;
		p2Layout.addLayoutComponent(p1TimerLabel, p2c);
		
		p2c.gridx = 0;
		p2c.gridy = 3;
		p2Layout.addLayoutComponent(activePlayerLabel, p2c);
		
		p2c.gridx = 1;
		p2c.gridy = 0;
		p2Layout.addLayoutComponent(instructionLabel, p2c);
		
		p2c.gridx = 1;
		p2c.gridy = 2;
		p2Layout.addLayoutComponent(startButton, p2c);
		
		p2c.gridx = 1;
		p2c.gridy = 3;
		p2Layout.addLayoutComponent(doneButton, p2c);
		
		p2c.gridx = 3;
		p2c.gridy = 1;
		p2Layout.addLayoutComponent(p2Label, p2c);
		
		p2c.gridx = 3;
		p2c.gridy = 2;
		p2Layout.addLayoutComponent(p2TimerLabel, p2c);
		
		//The elements for the third panel.
		p1Win = new javax.swing.JLabel();
		p2Win = new javax.swing.JLabel();
		doneButton2 = new javax.swing.JButton();
		
		//and it's layout
		
		p3c.anchor = GridBagConstraints.CENTER;
		p3c.weightx = 1;
		p3c.weighty = 1;
		p3c.gridx = 1;
		p3c.gridy = 2;
		
		p3Layout.addLayoutComponent(p1Win, p3c);
		
		p3c.gridx = 1;
		p3c.gridy = 3;
		p3Layout.addLayoutComponent(doneButton2, p3c);
		
		p3c.gridx = 1;
		p3c.gridy = 2;
		p3Layout.addLayoutComponent(p2Win, p3c);

		//For the main window, I guess. Does it ever mention the main window?
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess Clock");

		//The elements of the first panel.
        titleLable.setFont(new java.awt.Font("Ubuntu", 0, 28)); 
        titleLable.setText("How long would you like your game to be?");
        panel1.add(titleLable);

        hourSlider.setMaximum(60);
        hourSlider.setValue(0);
        hourSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hourSliderStateChanged(evt);
            }
        });
        panel1.add(hourSlider);

        minuteSlider.setMaximum(60);
        minuteSlider.setValue(0);
        minuteSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minuteSliderStateChanged(evt);
            }
        });
        panel1.add(minuteSlider);

        secondSlider.setMaximum(60);
        secondSlider.setValue(0);
        secondSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                secondSliderStateChanged(evt);
            }
        });
        panel1.add(secondSlider);

        hourNote.setText("Hours");
        panel1.add(hourNote);

        minuteNote.setText("Minutes");
        panel1.add(minuteNote);

        secondNote.setText("Seconds");
        panel1.add(secondNote);

        hourShow.setText("0");
        panel1.add(hourShow);

        minuteShow.setText("0");
        panel1.add(minuteShow);

        secondShow.setText("0");
        panel1.add(secondShow);
		
		readyButton.setText("Ready");
        readyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyButtonActionPerformed(evt);
            }
        });
        panel1.add(readyButton);

		//The first "card"
        panel1.setBounds(0, 10, 960, 290);
		
		//Adding the first card to the card holder.
        mainPanel.add(panel1, PANELONE);

		
		//The elements of the second panel.
        panel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel2KeyPressed(evt);
            }
        });

        p1TimerLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
		panel2.add(p1TimerLabel);
		
		p2TimerLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
		panel2.add(p2TimerLabel);

        startButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        startButton.setText("Start!");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
		panel2.add(startButton);

        doneButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });
		panel2.add(doneButton);
		
		activePlayerLabel.setBackground(new java.awt.Color(254, 254, 254));
        activePlayerLabel.setOpaque(true);
		panel2.add(activePlayerLabel);

        p1Label.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        p1Label.setText("Player 1");
		panel2.add(p1Label);

        p2Label.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        p2Label.setText("Player 2");
		panel2.add(p2Label);

        instructionLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        instructionLabel.setText("Press \"space\" to switch players.");
		panel2.add(instructionLabel);
		
		//Set size and add to mainPanel.
		panel2.setBounds(0, 0, 960, 290);	
		mainPanel.add(panel2, PANELTWO);
		
		//The elements of the third panel.

        p1Win.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        p1Win.setText("Player 1 wins!");
		panel3.add(p1Win);

        p2Win.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        p2Win.setText("Player 2 wins!");
		panel3.add(p2Win);
		
		doneButton2.setFont(new java.awt.Font("Ubuntu", 0, 24)); 
        doneButton2.setText("Done");
        doneButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButton2ActionPerformed(evt);
            }
        });
		panel3.add(doneButton2);
		
		//Set size and add to main panel.
		panel3.setBounds(0, 0, 960, 290);
		mainPanel.add(panel3, PANELTHREE);
        

		//Configuration for the main panel.
		mainPanel.setLayout(mpLayout);
		mainPanel.setBounds(0, 0, 960, 290);
		
		//Config for the JFrame.
        add(mainPanel);
		pack();
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
//The listener for the "space bar" that switches the active player.
    private void panel2KeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == 32 && clock1.paused  == false){clock1.switchPlayers();}
        else if(evt.getKeyCode() == 80){clock1.pauseAlt();}
        else if (evt.getKeyCode() == 27){System.exit(1);}
        //Grabs KeyCode of pressed key.
	//System.out.println(evt.getKeyCode());
    }
//The listener for the second "Done" button.
    private void doneButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(1);
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
            mpLayout.show(mainPanel, PANELONE);
        }
        else if (ui == 1 && phase == 2){}
        else if (ui == 2 && phase == 1){
            mpLayout.show(mainPanel, PANELTWO);
        }
        else if (ui == 2 && phase == 2){
            startButton.setVisible(false);
        }
		else if (ui == 3 && phase == 1){
			mpLayout.show(mainPanel, PANELTHREE);
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
                p1Win.setVisible(false);
            }
            else if(!p1Active){
                p2Win.setVisible(false);
            }
			switchUI(3,1);
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
	final static String PANELONE = "The first panel.";
	final static String PANELTWO = "The second panel.";
	final static String PANELTHREE = "The third panel.";
	private java.awt.GridBagConstraints p1c;
	private java.awt.GridBagConstraints p2c;
	private java.awt.GridBagConstraints p3c;
	private javax.swing.JPanel mainPanel;
	private java.awt.CardLayout mpLayout;
	private java.awt.GridBagLayout p1Layout;
	private java.awt.GridBagLayout p2Layout;
	private java.awt.GridBagLayout p3Layout;
	private javax.swing.JPanel panel1;
	private javax.swing.JPanel panel2;
	private javax.swing.JPanel panel3;
	private javax.swing.JButton doneButton2;
    private javax.swing.JLabel activePlayerLabel;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel hourNote;
    private javax.swing.JLabel hourShow;
    private javax.swing.JSlider hourSlider;
    private javax.swing.JLabel p1Label;
    private javax.swing.JLabel p2Label;
    private javax.swing.JLabel instructionLabel;
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
