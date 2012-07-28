
package controlador;


public class MaestroUsuario
{

    public boolean estadoactivo(int nivel, String estado)
    {
        boolean resultado = false;
        switch(nivel)
        {
        default:
            break;

        case 1: 
            if(estado.equalsIgnoreCase("Activo"))
                resultado = true;
            break;

        case 2: 
            if(estado.equalsIgnoreCase("Inactivo"))
                resultado = true;
            break;
        }
        return resultado;
    }

    public boolean numeros(int nivel, String valor)
    {
        boolean resultado = false;
        switch(nivel)
        {
        case 1: 
            if(EsNumero(valor))
                resultado = true;
            break;

        case 2: 
            if(EsNumero(valor))
                resultado = true;
            break;
        case 3:
            if(EsNumero(valor))
                resultado = true;
            break;
        case 4:
            if(EsNumero(valor))
                resultado = true;
            break;
        default:
            break;
        }
        return resultado;
    }

    private static boolean EsNumero(String cadena)
    {
        try
        {
            Integer.parseInt(cadena);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
    
    public boolean cadenas(String cadena)
    {
    	boolean resultado=false;
    	int sw=0;
    	String tecla=" ";
    	String compara=" ";
    	String simbolos=" ";
    	int largo1=cadena.length();
    	int largo2=cadena.length();
    	
    	for(int x=0;x<largo1;x++)
    	{
    		tecla=cadena.substring(x,x+1);
            if(EsNumero(tecla))
            {
            	//System.out.println("Hay numero:"+tecla);
            	x=largo1;
            	sw=1;
            }
            
            simbolos="-|#$%&/()=?¿<>,{}[]@_.";
            largo2=simbolos.length();
            for(int y=0;y<largo2;y++)
            {
            	compara=simbolos.substring(y,y+1);
            	if(tecla.equalsIgnoreCase(compara))
            	{
            		//System.out.println("Hay simbolo:"+tecla);
                	x=largo1;
            		y=largo2;
                	sw=1;
            	}
            	
            }
            
    	}

    	if (sw==1)
    	    resultado=false;
    	else
    		resultado=true;
    	
    	return resultado;
    	
    }
    
    public boolean correos(String email)
    {
    	boolean resultado=false;
    	int sw=0;
    	int arroba=0;
    	String tecla=" ";
    	String compara=" ";
    	String simbolos=" ";
    	int largo1=email.length();
    	int largo2=0;
    	
    	for(int x=0;x<largo1;x++)
    	{
    		tecla=email.substring(x,x+1);
            
            simbolos="1234567890@._abcdefghijklmnopqrstuvwxyz";
            largo2=simbolos.length();
            for(int y=0;y<largo2;y++)
            {
            	compara=simbolos.substring(y,y+1);
            	
            	if(tecla.equalsIgnoreCase(compara))
            	{
            		
            		if (x==0)
            		{
            			if(EsNumero(tecla))
            			{
                        	x=largo1;
                    		y=largo2;
                    		sw=1;
                    		//System.out.println("El primero es numero...");
            			}
            		}
            		if (y==10)
            		{
            			arroba=arroba+1;
            			//System.out.println("Muchas arrobas..."+x);
            		}
            		
            	}

            }
            
    	}
    	
    	for(int z=0;z<largo1;z++)
    	{
    		tecla=email.substring(z,z+1);
            
            simbolos="-|#$%&/()=?¿<>,{}[]";
            largo2=simbolos.length();
            for(int w=0;w<largo2;w++)
            {
            	compara=simbolos.substring(w,w+1);
            	if(tecla.equalsIgnoreCase(compara))
            	{
            		//System.out.println("Hay simbolo raro..");
                	z=largo1;
            		w=largo2;
                	sw=2;
            	}
            	
            }
            
    	}
  

    	if (sw==1 || arroba>1 || largo1<10 || sw==2)
    	    resultado=false;
    	else
    		resultado=true;
 
    	//System.out.println("sw..."+sw);
    	//System.out.println("arrobas..."+arroba);
    	//System.out.println("largo..."+largo1);
    	
    	
    	
    	return resultado;
    	
    }
    
}