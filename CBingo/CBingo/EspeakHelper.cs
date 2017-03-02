using System;

namespace CBingo
{
	public class EspeakHelper
	{
		public static string ToEspeak(int number) {
			string text = number.ToString();
			if (text.Length == 2) 
				text = string.Format("{0} {1} {2}", text, text [0], text [1]);
			return string.Format("'{0}'", text);
		}
	}
}

