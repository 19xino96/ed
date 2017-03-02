using System;
using System.Diagnostics;
using Gtk;
using System.Collections.Generic;

using CBingo;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
//		buttonGoForward.Clicked += delegate {
//			Process.Start("espeak", "-v es '" + entryNumero.Text + "'");
//
//		};

//		IList<int> list = new List<int> ();
//		list.Add (16);
//		list.Add (15);
//		list.Add (17);
//		list.Add (5);
//		list.Add (4);
//
//		foreach (int item in list)
//			Console.WriteLine ("item=" + item);
		Table table = new Table (9, 10, true);
		IList<Button> buttons = new List<Button> ();
		IList<int> bolas = new List<int> ();
		for (int numero = 1; numero <= 90; numero++) {
			bolas.Add (numero);
			uint index = (uint)numero - 1;
			Button button = new Button ();
			button.Label = "" + numero;
			button.Visible = true;
			uint row = index / 10;
			uint column = index % 10;
			table.Attach (button, column, column + 1, row, row + 1);
			buttons.Add (button);
		}
		table.Visible = true;
		vBoxMain.Add(table);

		Random random = new Random ();

		buttonGoForward.Clicked += delegate {
			Console.WriteLine("delegado anterior a la extracción");
		};

		buttonGoForward.Clicked += delegate {
			int randomIndex = random.Next(bolas.Count);
			int bola = bolas[randomIndex];
			Console.WriteLine("bola = " + bola);
			bolas.Remove(bola);
			if (bolas.Count == 0)
				buttonGoForward.Sensitive = false;
			Process.Start("espeak", " -v es " + EspeakHelper.ToEspeak(bola));
			buttons[bola - 1].ModifyBg (StateType.Normal, new Gdk.Color (228, 128, 0));
		};

//		for (int vez = 0; vez < int.MaxValue; vez++) {
//			int numeroAleatorio = random.Next (1000);
//			if (numeroAleatorio < 5 || numeroAleatorio >= 995)
//				Console.WriteLine ("vez=" + vez + " numeroAleatorio = " + numeroAleatorio);
//		}
		
	}

//	private string toEspeak(int bola) {
//		//string text = bola.ToString ();
//		//text = text + " " + text[0] + " " + text[1];
//		if (bola > 9) {
//			return "\"" + bola.ToString() + ". " + (bola/10).ToString() + ", " + (bola%10).ToString() + "\" -v es";
//		} else {
//			return bola.ToString() + " -v es";
//		}
//	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
