import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GUI_Frame {
	
	 static JLabel myLabel;
	 static JButton hold;
	 static JButton myButton;
	 static JButton textFieldUpdate;
	 static JLabel outcome;
	 static JLabel dice1, dice2;
	 static Color win, fail, draw;
	 
	 static Die roll = new Die(6);
		
		static int playerScore = 0;
		static int playDie1 = 0;
		static int playDie2 = 0;
		static int playerTotal = 0;
		static int comScore = 0;
		static int comTotal = 0;
		static int comDie1 = 0;
		static int comDie2 = 0;
		
	 
	 
	 public static void main(String[] args) {
	        // Create a window for our app
	        JFrame myFrame = new JFrame("Example 11.1");
	        // Set it to quit the app when we close the window
	        // NOTE that this is the default behavior--we could omit this here
	        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	       // GridBagLayout l = new GridBagLayout();
	        //GridBagConstraints lay = new GridBagConstraints();
	        BorderLayout b = new BorderLayout();
	        GridLayout g = new GridLayout(4,1);
	        GridLayout h = new GridLayout(2,1);
	        JPanel p = new JPanel(h);
	        JPanel j = new JPanel(g);
	        ActionListener listener = new MyListener();
	        //p.setLayout(g);
	        Dimension d = new Dimension(45,60);
	        
	        
	      //  BoxLayout;
	      //  FlowLayout;
	        
	       myFrame.setLayout(b); 
	        
	        myFrame.setTitle("Game of TwentyOne");
	        
	        dice2 = new JLabel();
	        dice2.setPreferredSize(d);
	        j.setPreferredSize(new Dimension(25, 25));
	        j.add(dice2);
	        myFrame.add(j, BorderLayout.CENTER);
	        
	        dice1 = new JLabel();
	        dice1.setPreferredSize(d);
	        j.setPreferredSize(new Dimension(60, 65));
	        j.add(dice1);
	        myFrame.add(j, BorderLayout.CENTER);
	        
	        outcome = new JLabel();
	        outcome.setPreferredSize(d);
	        outcome.setFont(new Font("TimesRoman", Font.ITALIC, 20));
	        j.setPreferredSize(new Dimension(60, 65));
	        j.add(outcome);
	        myFrame.add(j, BorderLayout.CENTER);
	       
	        myLabel = new JLabel("Your Score");
	        myLabel.setPreferredSize(d);
	        j.setPreferredSize(new Dimension(70, 140));
	        j.add(myLabel);
	        myFrame.add(j, BorderLayout.CENTER);
	        
	        hold = new JButton("Hold");
	        hold.setPreferredSize(d);
	        hold.setFont(new Font("TimesRoman", Font.ITALIC, 12));
	        hold.addActionListener(listener);
	        p.add(hold);
	        myFrame.add(p, b.SOUTH);
	       // myFrame.add(hold, g);
	        
	        myButton = new JButton("Roll Die");
	        d = new Dimension(45,60);
	        myButton.setPreferredSize(d);
	        myButton.setFont(new Font("TimesRoman", Font.ITALIC, 12));
	        p.add(myButton);
	        myButton.addActionListener(listener);
	        myFrame.add(p, BorderLayout.SOUTH);
	       
	        j = new JPanel(h);
	        j.setPreferredSize(new Dimension(150,400));
	        myFrame.add(j, BorderLayout.WEST);
	       
	        
	        //dsfsdfsdf
	        //fdhsfkljdsfhklj
	        //fgdgfdklj
	        
	       // ActionListener listener = new MyListener();
	       // myButton.addActionListener(listener);
	        
	        
	     //  myButton.setPreferredSize(new Dimension(40,40));
	      //myButton.setBounds(r);
	       //myFrame.add(myButton);
	       
	       myFrame.pack();
	     myFrame.setSize(700, 500);  
	     myFrame.setVisible(true);
	 }
	 
	 
	 
	 static class MyListener implements ActionListener {

		  // Color theColors[] = {Color.BLUE, Color.RED, Color.GREEN, Color.BLACK, Color.WHITE};
	      //int index = 0;
		 public void actionPerformed(ActionEvent e) {
	            //JButton eventSource = (JButton) e.getSource();
	            //eventSource.setForeground(theColors[index++]);
	            JButton eventSource = (JButton)e.getSource();
	           
	           switch(eventSource.getText()){
	           
	           case ("Roll Die"):
	           
	           //( eventSource.getText().equals("Roll Die") ): {
	               // myLabel.setText( myTextField.getText() );
	        	  
	        	 
	        	   
	            	roll.roll();
	            	
	    			comDie1 = roll.getValue();// uses Die class method
	    			roll.roll();
	    			comDie2 = roll.getValue();
	    			comScore = comDie1 + comDie2;
	    			comTotal = comTotal + comScore;
	    			
	    			roll.roll();
					playDie1 = roll.getValue();// uses Die class method
					roll.roll();
					playDie2 = roll.getValue();
					playerScore = playDie1 + playDie2;
					playerTotal = playerTotal + playerScore;
					
					myLabel.setText( "Your score is: " + playerTotal );
					
					dice1.setText("Die 1:    " + playDie1); 
					dice2.setText("Die 2:    " + playDie2);
	            	
					if(playerTotal > 21 || comTotal > 21){
						
						endLogic(playerTotal, comTotal);
						
					}
					break;
	            	
	            	
					case ("Hold"):
					//(eventSource.getText().equals("Hold")) {
	               // myLabel.setForeground( theColors[++index] );
	                //if (index >= theColors.length - 1) {
	                //    index = -1;
						
	            	
						
	            	endLogic(playerTotal, comTotal);
					break;
					}
	            	
	            	
	                }
	            }
	        
	 
	 /**
	  * Logic for ending the game
	  */
	 		public static void endLogic(int playerTotal, int comTotal){
	 			win = Color.GREEN;
	 			fail = Color.RED;
	 			draw = Color.BLUE;
	 			
	 			
	 			myButton.setEnabled(false);;
				hold.setEnabled(false);;
	 			
	 			myLabel.setText("\nYou have " + playerTotal + " while the dealer has " + comTotal);
				
				
				if(playerTotal == comTotal){
					outcome.setText("Its a Draw");
					outcome.setForeground(draw);
					
					// end program
					
				}
				
				else if(playerTotal < comTotal && (comTotal <= 21))
				{
					
					outcome.setText("\nThe dealer won this game. You could have hit one more time.");
					outcome.setForeground(fail);
					//System.exit(0);// end program
					
				} else if(comTotal < playerTotal && playerTotal <= 21 ){
						
						outcome.setText("You win!");
						outcome.setForeground(win);
						//System.exit(0);// end program
					
					// runs if the user doesn't type y or n, so don't be a cheater
				}
						
				else if( playerTotal < comTotal && comTotal > 21 && playerTotal > 21) {
							outcome.setText("You win by having the lower number over 21");
							outcome.setForeground(win);
							//System.exit(0);// end program
				}
						
				else if(playerTotal >  comTotal && comTotal > 21 && playerTotal > 21) {
							outcome.setText("You loose. You were the furthest over 21");
							outcome.setForeground(fail);
							//System.exit(0);// end program
				}
						
				else if(playerTotal == comTotal && comTotal > 21 && playerTotal > 21) {
							outcome.setText("It's a DRAW!");
							outcome.setForeground(draw);
							//System.exit(0);// end program
				}
				 else if(playerTotal > comTotal && playerTotal > 21) {
				
				outcome.setText("The dealer won this game. You exceded 21");
				outcome.setForeground(fail);
				//System.exit(0);// end program
				 }
			
						
				else  {
					
					outcome.setText("\nYou win!");
					outcome.setForeground(win);
					//System.exit(0);// end program
				}
				
				
				
				
				
				//System.exit(0);
				
	 		}
	 }

	 		
	 		
	 			
	 			
	 		
		
	    

