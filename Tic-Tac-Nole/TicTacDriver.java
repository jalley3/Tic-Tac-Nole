

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacDriver extends JFrame implements ActionListener {
  private static final long serialVersionUID = 2279571833272255775L;
  //create 3 panels, one for board, one for title, and one for signature
  JPanel panel; 
  JPanel header;
  JPanel footer;
  XObutton[] button; //buttons for the board
  int sign = 0; 
  int count = 0; 
  int n = 3;
  int[][] board = new int[n][n]; //matrix for the board
  int row = 0;
  int col = 0;
  boolean win = false;
  public TicTacDriver(){
	  panel = new JPanel();
	  header = new JPanel();
	  footer = new JPanel();
	  //position and size the panels
	  this.add(header, BorderLayout.PAGE_START); 
	  this.add(footer, BorderLayout.PAGE_END);
	  Dimension d = new Dimension(800,400);
	  Dimension h = new Dimension(800,100);
	  Dimension f = new Dimension(800,100);
	  header.setPreferredSize(h);
	  panel.setPreferredSize(d);
	  footer.setPreferredSize(f);
	  //set layout of buttons for the board
	  panel.setLayout(new GridLayout(3,3));
	  footer.setBackground(new Color (133,39,78));
	  header.setBackground(new Color (133,39,78));
	  JLabel heading = new JLabel("FSU");
	  heading.setFont(new Font("Verdana",1,40));
	  heading.setForeground(new Color(255,215,0));
	  header.add(heading);
	  JLabel sig = new JLabel("By Jacob Alley");
	  sig.setFont(new Font("Verdana", 1, 40));
	  sig.setForeground(new Color (255,215,0));
	  footer.add(sig);
	  this.add(panel, BorderLayout.CENTER);
	  button = new XObutton[9];
	  //activate buttons
	  for (int i = 0; i < 9; i++){
		  button[i] = new XObutton();
		  panel.add(button[i]);
		  button[i].setEnabled(true);
		  button[i].addActionListener(this); //make interactable
		  button[i].setBackground(new Color(133, 39, 78));
	  }
	  setResizable(false);
	  this.pack();
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  this.setVisible(true);
  }
  public void actionPerformed (ActionEvent e){
	  count++; //track number of moves
	  for (int i = 0; i < 9; i++){
		  if (button[i] == e.getSource()){
			  if (sign%2 ==0) //check for x
			  { 
				  button[i].setIcon(button[i].ReturnX());
				  button[i].removeActionListener(this);//button cant be clicked twice
				  button[i].SetState(1);
				  AssignStates(i); //game logic
			  }
			  else
			  {
				  button[i].setIcon(button[i].ReturnO());
				  button[i].removeActionListener(this);
				  button[i].SetState(2);
				  AssignStates(i);
			  }
		  }
	  }
	 GameOver(); //test win conditions
	  sign++; //change turn
  }
  public void GameOver(){
	  for (int i = 0; i < n; i++) //3 vertical
	  {
		  if(board[row][i] != board[row][col])
			  break;
	      if (i == n-1){
	    	 win = true;
	    	 VictoryMessage();
	      }
		  
	  }
	  for (int i = 0; i < n; i++) //horizontal
	  {
		  if (board[i][col] != board[row][col])
			  break;
		  if (i == n-1){
			  win = true;
			  VictoryMessage();
			  
		  }
	  }
	  if (row == col) //diagonal
	  {
		  for(int i = 0; i < n; i++){
			  if(board[i][i] != board[row][col])
				  break;
			  if(i == n-1){
				  win = true;
				  VictoryMessage();
			  }
		  }
	  }
	  for (int i = 0; i < n; i++) //cross diagonal
	  {
		  if(board[i][(n-1)-i] != board[row][col])
			  break;
		  if(i == n-1){
			  win = true;
			  VictoryMessage();
		  }
	  }
	  if (count == 9 && !win) //cats game
	  {
		  JOptionPane.showMessageDialog(null,"Cat's Game");
		  dispose();
		  TicTacDriver.main(null); //restart
	  }
  }
  /*
   * this function takes the button interaction and manipulates the 
   * board matrix to reflect the user's choice.
   */
  public void AssignStates(int i){
	  if (i < 3){
		  board[0][i] = button[i].GetState();
		  row = 0;
		  col = i;
	  }
	  else if ((2 < i) && (i< 6)){
		  board[1][i%3] = button[i].GetState();
		  row = 1;
		  col = i%3;
	  }
	  else if ((5 < i) && (i < 9)){
		  board[2][i%3] = button[i].GetState();
		  row = 2;
		  col = i%3;
	  }
  }
  public void VictoryMessage(){
	  if(board[row][col] == 1) 
 		 JOptionPane.showMessageDialog(null, "X Wins");
 	 else 
 		 JOptionPane.showMessageDialog(null,"O Wins");
	  dispose();
	  TicTacDriver.main(null); //restart if victory is acheived
	  
  }
  public static void main (String[] args){
	  new TicTacDriver();
  }
}

 