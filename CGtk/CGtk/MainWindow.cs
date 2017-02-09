using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
		labelSaludo.Text = "Hola. Pon tu nombre y pulsa Adelante";

		Console.WriteLine("27/10 = " + 27/10 + " resto = " + 27%10);

		buttonGoForward.Clicked += delegate {
			labelSaludo.Text = "Hola (desde delegate) " + entryNombre.Text;
		};

		Table table = new Table (9, 10, true);
//		for (uint index=0; index<90; index++) {
//			Button button = new Button ();
//			button.Label = " " + (index+1);
//			button.Visible = true;
//			uint column = index / 10;
//			uint row = index % 10;
//			table.Attach(button, row, row+1, column, column+1);
//			vBoxMain.Add (button); //fuera
//			button.Clicked += delegate {
//				Console.WriteLine("clicked en " + button.Label);
//			};
//		}
		int index = 1;
		for (uint column = 0; column < 9; column++) {
			for (uint row = 0; row < 10; row++) {
				Button button = new Button ();
				button.Label = " " + (index);
				button.Visible = true;
				table.Attach(button, row, row+1, column, column+1);
				vBoxMain.Add (button); //fuera
				button.Clicked += delegate {
					Console.WriteLine("clicked en " + button.Label);
				};
				index++;
			}
		}
		table.Visible = true;
		vBoxMain.Add (table);


	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Console.WriteLine ("OnDeleteEvent");
		Application.Quit ();
		a.RetVal = true;
	}

//	protected void OnButtonGoForwardClicked (object sender, EventArgs e)
//	{
//		Button button = (Button)sender;
//		labelSaludo.Text = "Hola " + entryNombre.Text + " pulsado " + button.Label;
//	}
}
