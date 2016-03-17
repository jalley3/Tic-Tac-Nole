
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class XObutton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon X,O;
	int state = 0;
	
	public XObutton(){
		X = new ImageIcon(this.getClass().getResource("x.png"));
		O = new ImageIcon(this.getClass().getResource("o.png"));
	}
	public ImageIcon ReturnX(){
		return X;
	}
	public ImageIcon ReturnO(){
		return O;
	}
	public void SetState (int b){
		state = b;
	}
	public int GetState (){
		return state;
	}
}
