package KTEngine.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

	protected class Key {
		
		private boolean isPressed;
		private final int VK;
		
		public Key(int VK){
			this.VK = VK; 
			this.isPressed = false;
		}
		
		public boolean isPressed() {
			return isPressed;
		}
		
		public void press(){
			isPressed = true;
		}
		
		public void depress(){
			isPressed = false;
		}
		
		public int getVK() {
			return VK;
		}
	}
	
	public Key a;
	public Key b;
	public Key c;
	public Key d;
	public Key e;
	public Key f;
	public Key g;
	public Key h;
	public Key i;
	public Key j;
	public Key k;
	public Key l;
	public Key m;
	public Key n;
	public Key o;
	public Key p;
	public Key q;
	public Key r;
	public Key s;
	public Key t;
	public Key u;
	public Key v;
	public Key w;
	public Key x;
	public Key y;
	public Key z;

	public InputHandler() {
		a = new Key(KeyEvent.VK_A);
		b = new Key(KeyEvent.VK_B);
		c = new Key(KeyEvent.VK_C);
		d = new Key(KeyEvent.VK_D);
		e = new Key(KeyEvent.VK_E);
		f = new Key(KeyEvent.VK_F);
		g = new Key(KeyEvent.VK_G);
		h = new Key(KeyEvent.VK_H);
		i = new Key(KeyEvent.VK_I);
		j = new Key(KeyEvent.VK_J);
		k = new Key(KeyEvent.VK_K);
		l = new Key(KeyEvent.VK_L);
		m = new Key(KeyEvent.VK_M);
		n = new Key(KeyEvent.VK_N);
		o = new Key(KeyEvent.VK_O);
		p = new Key(KeyEvent.VK_P);
		q = new Key(KeyEvent.VK_Q);
		r = new Key(KeyEvent.VK_R);
		s = new Key(KeyEvent.VK_S);
		t = new Key(KeyEvent.VK_T);
		u = new Key(KeyEvent.VK_U);
		v = new Key(KeyEvent.VK_V);
		w = new Key(KeyEvent.VK_W); 
		x = new Key(KeyEvent.VK_X);
		y = new Key(KeyEvent.VK_Y);
		z = new Key(KeyEvent.VK_Z);
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
			case KeyEvent.VK_A:
				a.press();
				break;
			case KeyEvent.VK_B:
				b.press();
				break;
			case KeyEvent.VK_C:
				c.press();
				break;
			case KeyEvent.VK_D:
				d.press();
				break;
			case KeyEvent.VK_E:
				e.press();
				break;
			case KeyEvent.VK_F:
				f.press();
				break;
			case KeyEvent.VK_G:
				g.press();
				break;
			case KeyEvent.VK_H:
				h.press();
				break;
			case KeyEvent.VK_I:
				i.press();
				break;
			case KeyEvent.VK_J:
				j.press();
				break;
			case KeyEvent.VK_K:
				k.press();
				break;
			case KeyEvent.VK_L:
				l.press();
				break;
			case KeyEvent.VK_M:
				m.press();
				break;
			case KeyEvent.VK_N:
				n.press();
				break;
			case KeyEvent.VK_O:
				o.press();
				break;
			case KeyEvent.VK_P:
				p.press();
				break;
			case KeyEvent.VK_Q:
				q.press();
				break;
			case KeyEvent.VK_R:
				r.press();
				break;
			case KeyEvent.VK_S:
				s.press();
				break;
			case KeyEvent.VK_T:
				t.press();
				break;
			case KeyEvent.VK_U:
				u.press();
				break;
			case KeyEvent.VK_V:
				v.press();
				break;
			case KeyEvent.VK_W:
				w.press();
				break;
			case KeyEvent.VK_X:
				x.press();
				break;
			case KeyEvent.VK_Y:
				y.press();
				break;
			case KeyEvent.VK_Z:
				z.press();
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		switch(event.getKeyCode()) {
			case KeyEvent.VK_A:
				a.depress();
				break;
			case KeyEvent.VK_B:
				b.depress();
				break;
			case KeyEvent.VK_C:
				c.depress();
				break;
			case KeyEvent.VK_D:
				d.depress();
				break;
			case KeyEvent.VK_E:
				e.depress();
				break;
			case KeyEvent.VK_F:
				f.depress();
				break;
			case KeyEvent.VK_G:
				g.depress();
				break;
			case KeyEvent.VK_H:
				h.depress();
				break;
			case KeyEvent.VK_I:
				i.depress();
				break;
			case KeyEvent.VK_J:
				j.depress();
				break;
			case KeyEvent.VK_K:
				k.depress();
				break;
			case KeyEvent.VK_L:
				l.depress();
				break;
			case KeyEvent.VK_M:
				m.depress();
				break;
			case KeyEvent.VK_N:
				n.depress();
				break;
			case KeyEvent.VK_O:
				o.depress();
				break;
			case KeyEvent.VK_P:
				p.depress();
				break;
			case KeyEvent.VK_Q:
				q.depress();
				break;
			case KeyEvent.VK_R:
				r.depress();
				break;
			case KeyEvent.VK_S:
				s.depress();
				break;
			case KeyEvent.VK_T:
				t.depress();
				break;
			case KeyEvent.VK_U:
				u.depress();
				break;
			case KeyEvent.VK_V:
				v.depress();
				break;
			case KeyEvent.VK_W:
				w.depress();
				break;
			case KeyEvent.VK_X:
				x.depress();
				break;
			case KeyEvent.VK_Y:
				y.depress();
				break;
			case KeyEvent.VK_Z:
				z.depress();
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent event) {

	}
}


