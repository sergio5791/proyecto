package dl;

public class General {
	
    String text;
    int value;

@Override
    public String toString() {
        return "duration{" + "text=" + text + ", value=" + value + '}';
    }

public void mostrar (){
	System.out.println("valor-> "+value);
}

}
