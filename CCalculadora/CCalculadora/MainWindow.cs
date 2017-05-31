using System;
using Gtk;
using System.Collections.Generic;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();

		//Se trata de una calculadora virtual que realiza sumas y restas

		int result = 0; // La cuenta que llevamos. Se va actualizando conforme hacemos operaciones y cuando hacemos click en 'Intro'
		String num = ""; // Representa el numero que vamos introduciendo para realizar una operación
		bool negativo = false; // Indica si el número actual es negativo
		bool suma = false; // Indica si la última operación fue una suma
		bool resta = false;  // Indica si la última operación fue una resta

		// La 'pantallita' donde se visualizan las operaciones/resultados
		Entry entry = new Entry();
		entry.IsEditable = false;
		entry.Visible = true;
		hBoxTop.Add (entry);

		// El botón 'Intro' y el botón 'C' (Clear)
		Table tableIntroC = new Table(1, 2, true);
		IList<Button> buttonsIntroC = new List<Button>();
		String[] strIntroC = { "Intro", "C" };
		for (int i = 0; i< 2; i++) {
			Button buttonIntroC = new Button();
			buttonIntroC.Visible = true;
			uint row = 0;
			uint column = (uint) i;
			buttonIntroC.Label = strIntroC[i];
			tableIntroC.Attach (buttonIntroC, column, column + 1, row, row + 1);
			buttonsIntroC.Add (buttonIntroC);
		}
		tableIntroC.Visible = true;
		hBoxTop.Add(tableIntroC);
		for (int i = 0; i < 2; i++)
		{
			int index = i;
			buttonsIntroC[i].Clicked += delegate
			{
				if (index == 0) // Botón intro: muestra el resultado de las operaciones realizadas (se pueden seguir realizando operaciones con el resultado)
				{	
					if (!num.Equals(""))
					{
						if (suma)
						{
							result += Convert.ToInt32(num);
						}
						else if (resta)
						{
							result -= Convert.ToInt32(num);
						}
						else 
						{
							result += Convert.ToInt32(num);
						}
						num = Convert.ToString(result);
						entry.Text = num;
						suma = false;
						resta = false;
						result = 0;					
					}
				}
				else // Botón clear: limpia la pantalla y prepara la calculadora para una nueva operación desde cero
				{	
					result = 0;
					num = "";
					negativo = false;
					suma = false;
					resta = false;
					entry.Text = "";
				}
			};
		}

		// Los botones para introducir los números y un botón 'return' para borrar la ultima cifra.
		Table tableNum = new Table (4, 3, true);
		IList<Button> buttonsNum = new List<Button> ();
		for (int i = 0; i < 11; i++)
		{
			Button buttonNum = new Button ();
			buttonNum.Visible = true;
			uint row = (uint) i / 3;
			uint column = (uint) i % 3;
			if (i < 9) {
				buttonNum.Label = "" + (i+1);
				tableNum.Attach (buttonNum, column, column + 1, row, row + 1);
			} else if (i < 10) {
				buttonNum.Label = "0";
				tableNum.Attach (buttonNum, column, column + 1, row, row + 1);
			} else {
				buttonNum.Label = "<--";
				tableNum.Attach (buttonNum, column, column + 2, row, row + 1);
			}
			buttonsNum.Add (buttonNum);
		}
		tableNum.Visible = true;
		hBoxBottom.Add(tableNum);
		for (int i = 0; i < 10; i++) // Números
		{
			int index = i;			buttonsNum[i].Clicked += delegate
			{
				String cifra = buttonsNum[index].Label;
				num += cifra;
				entry.Text += cifra;
			};
		}
		buttonsNum[10].Clicked += delegate // Return: borrar una a una las cifras del número actual; no puede deshacer operaciones ya introducidas
		{
			if (!num.Equals(""))
			{
				if (num.Length > 1)
				{
					num = num.Substring(0, num.Length - 1);
					entry.Text = entry.Text.Substring(0, entry.Text.Length - 1);
				}
				else
				{
					num = "";
					entry.Text = entry.Text.Substring(0, entry.Text.Length - 1);
				}

			}
			else if (negativo) // Si se ha introducido un número negativo, borra el guión y elimina su efecto
			{
				if (resta)
				{
					suma = true;
					resta = false;
				}
				else
				{
					suma = false;
					resta = true;
				}
				negativo = false;	
				entry.Text = entry.Text.Substring(0, entry.Text.Length - 1);
			}
		};

		//Botones de suma y resta, para realizar operaciones e introducir numeros negativos
		Table tableOperadores = new Table (2, 1, true);
		IList<Button> buttonsOperadores = new List<Button> ();
		String[] strOperadores = {"+","-"};
		for (int i = 0; i < 2; i++) {
			Button buttonOperador = new Button ();
			buttonOperador.Visible = true;
			uint row = (uint) i;
			uint column = 0;
			buttonOperador.Label = strOperadores[i];
			tableOperadores.Attach (buttonOperador, column, column + 1, row, row + 1);
			buttonsOperadores.Add (buttonOperador);
		}
		tableOperadores.Visible = true;
		hBoxBottom.Add(tableOperadores);
		for (int i = 0; i < 2; i++)
		{	
			int index = i;
			buttonsOperadores[i].Clicked += delegate
			{
				if (!num.Equals(""))
				{
					if (suma)
					{
						result += Convert.ToInt32(num);
					}
					else if (resta)
					{
						result -= Convert.ToInt32(num);
					}
					else
					{
						result += Convert.ToInt32(num);
					}
					if (index == 0) // Suma
					{
						suma = true;
						resta = false;
						entry.Text += " + ";
					}
					else // Resta
					{
						suma = false;
						resta = true;
						entry.Text += " - ";
					}
					num = ""; 
					negativo = false;
				}
				else 
				{
					if (index == 1 && !negativo) // Transforma el próximo numero en negativo.
					{
						if (resta)
						{
							suma = true;
							resta = false;
						}
						else
						{
							suma = false;
							resta = true;
						}
						entry.Text += "-";
						negativo = true;
					}
				}
			};
		}
	}



	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
