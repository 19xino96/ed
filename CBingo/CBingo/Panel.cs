using Gtk;
using System;
using System.Collections.Generic;
	
namespace CBingo
{
	public class Panel
	{
		private Table table = new Table (9, 10, true);
		private IList<Button> ButtonsType = new List<Button>();
		public Panel ()
		{
			for (int index = 0; index < 90; index++) {
				Button button = new Button ();
				int numero = index + 1;
				button.Label = numero.ToString ();
				uint row = index / 10;
				uint column = index % 10;
				table.Attach (button, column, column + 1, row + 1);
				ButtonsType.Add (button);
			} 
		}
	}
}

