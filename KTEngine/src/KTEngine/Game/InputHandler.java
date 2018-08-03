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
		
		public void toggle(){
			isPressed = !isPressed;
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
				a.toggle();
				break;
			case KeyEvent.VK_B:
				b.toggle();
				break;
			case KeyEvent.VK_C:
				c.toggle();
				break;
			case KeyEvent.VK_D:
				d.toggle();
				break;
			case KeyEvent.VK_E:
				e.toggle();
				break;
			case KeyEvent.VK_F:
				f.toggle();
				break;
			case KeyEvent.VK_G:
				g.toggle();
				break;
			case KeyEvent.VK_H:
				h.toggle();
				break;
			case KeyEvent.VK_I:
				i.toggle();
				break;
			case KeyEvent.VK_J:
				j.toggle();
				break;
			case KeyEvent.VK_K:
				k.toggle();
				break;
			case KeyEvent.VK_L:
				l.toggle();
				break;
			case KeyEvent.VK_M:
				m.toggle();
				break;
			case KeyEvent.VK_N:
				n.toggle();
				break;
			case KeyEvent.VK_O:
				o.toggle();
				break;
			case KeyEvent.VK_P:
				p.toggle();
				break;
			case KeyEvent.VK_Q:
				q.toggle();
				break;
			case KeyEvent.VK_R:
				r.toggle();
				break;
			case KeyEvent.VK_S:
				s.toggle();
				break;
			case KeyEvent.VK_T:
				t.toggle();
				break;
			case KeyEvent.VK_U:
				u.toggle();
				break;
			case KeyEvent.VK_V:
				v.toggle();
				break;
			case KeyEvent.VK_W:
				w.toggle();
				break;
			case KeyEvent.VK_X:
				x.toggle();
				break;
			case KeyEvent.VK_Y:
				y.toggle();
				break;
			case KeyEvent.VK_Z:
				z.toggle();
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		switch(event.getKeyCode()) {
			case KeyEvent.VK_A:
				a.toggle();
				break;
			case KeyEvent.VK_B:
				b.toggle();
				break;
			case KeyEvent.VK_C:
				c.toggle();
				break;
			case KeyEvent.VK_D:
				d.toggle();
				break;
			case KeyEvent.VK_E:
				e.toggle();
				break;
			case KeyEvent.VK_F:
				f.toggle();
				break;
			case KeyEvent.VK_G:
				g.toggle();
				break;
			case KeyEvent.VK_H:
				h.toggle();
				break;
			case KeyEvent.VK_I:
				i.toggle();
				break;
			case KeyEvent.VK_J:
				j.toggle();
				break;
			case KeyEvent.VK_K:
				k.toggle();
				break;
			case KeyEvent.VK_L:
				l.toggle();
				break;
			case KeyEvent.VK_M:
				m.toggle();
				break;
			case KeyEvent.VK_N:
				n.toggle();
				break;
			case KeyEvent.VK_O:
				o.toggle();
				break;
			case KeyEvent.VK_P:
				p.toggle();
				break;
			case KeyEvent.VK_Q:
				q.toggle();
				break;
			case KeyEvent.VK_R:
				r.toggle();
				break;
			case KeyEvent.VK_S:
				s.toggle();
				break;
			case KeyEvent.VK_T:
				t.toggle();
				break;
			case KeyEvent.VK_U:
				u.toggle();
				break;
			case KeyEvent.VK_V:
				v.toggle();
				break;
			case KeyEvent.VK_W:
				w.toggle();
				break;
			case KeyEvent.VK_X:
				x.toggle();
				break;
			case KeyEvent.VK_Y:
				y.toggle();
				break;
			case KeyEvent.VK_Z:
				z.toggle();
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}


