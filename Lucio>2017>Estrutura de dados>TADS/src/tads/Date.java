package tads;

public class Date {

	public int dia, mes, ano;
	public String date;
	
	public boolean validateDayMonthYear(int day, int month, int year){
		if (month<1 || month >12){
			return false;
		}
		switch(month){
			case 4:
			case 6:
			case 9:
			case 11:
				if (day<1 || day>30)
					return false;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day<1 || day>31)
					return false;
				break;
			case 2:
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 )){
					if (day<1 || day >29)
						return false;
				} else {
					if (day<1 || day>28)
						return false;
				}
				break;
		}
		
		return true;
	}
	
	public boolean validateStringDate(String date){
		String[] sDate = date.split("/");
		return this.validateDayMonthYear(Integer.parseInt(sDate[0]), Integer.parseInt(sDate[1]), Integer.parseInt(sDate[2]));
	}
	
	public String writeLongDate(String date){
		String[] sDate = date.split("/");
		if (this.validateDayMonthYear(Integer.parseInt(sDate[0]), Integer.parseInt(sDate[1]), Integer.parseInt(sDate[2]))){
		 	StringBuilder sb = new StringBuilder();
		 	sb.append(sDate[0]);
		 	sb.append(" de ");
		 	sb.append(this.getLongMonth(Integer.parseInt(sDate[1])));
		 	sb.append(" de ");
		 	sb.append(sDate[2]);
		 	return sb.toString();
		}
		return "\nData Inválida!!!";
	}
	
	public String getLongMonth(int month){
		StringBuilder sb = new StringBuilder();
		switch (month){
			case 1:
				sb.append("Janeiro");
				break;
			case 2:
				sb.append("Fevereiro");
				break;
			case 3:
				sb.append("Março");
				break;
			case 4:
				sb.append("Abril");
				break;
			case 5:
				sb.append("Maio");
				break;
			case 6:
				sb.append("Junho");
				break;
			case 7:
				sb.append("Julho");
				break;
			case 8:
				sb.append("Agosto");
				break;
			case 9:
				sb.append("Setembro");
				break;
			case 10:
				sb.append("Outubro");
				break;
			case 11:
				sb.append("Novembro");
				break;
			case 12:
				sb.append("Dezembro");
				break;
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[dia=");
		builder.append(dia);
		builder.append(", mes=");
		builder.append(mes);
		builder.append(", ano=");
		builder.append(ano);
		builder.append("]");
		return builder.toString();
	}
	
	
}
