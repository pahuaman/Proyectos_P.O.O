/**
 * @(#)Alumno.java
 * Practica Individual
 * Control Escolar
 * @author Garfia Pahua Jose G.
 * @version 1.00 2014/3/25
 */
 
import java.io.IOException;;
/************ SuperClase **************/
class Alumno {
    //atributos
    int codigo;
    String nombre, carrera;

    //constructor
    public Alumno(int codigo,String nombre,String carrera) {
    	this.codigo=codigo;
    	this.nombre=nombre;
    	this.carrera=carrera;
    }
    //familia de metodos mostrar
    public void mostrarAlumno(){
    	System.out.println("CODIGO       = "+codigo);
    	System.out.println("NOMBRE       = "+nombre);
    	System.out.println("CARRERA      = "+carrera);
    }

    //familia de metodos cambiar
    public void cambiarAlumno(int codigo,String nombre,String carrera){
    	this.codigo=codigo;
    	this.nombre=nombre;
    	this.carrera=carrera;
    }


    //familia de metodos regresar
    public int regresarCodigo(){
    	return codigo;
    }


    //metodo principal
    public static void main(String[] args) throws Exception {
        //arreglos de referencias
        AlumnoDeCuota adc[]=new AlumnoDeCuota[9];
        AlumnoDeBeca  adb[]=new AlumnoDeBeca [9];
       
        //creando un objeto lector
        Lector lec=new Lector();
        //variables
        int opc,codigo,ind_adc,cont_adc,aux;
        opc=codigo=ind_adc=cont_adc=0; int ind_adb=0,cont_adb=0,cont_gen=0;
        double cuota=0.0;
        String nombre,carrera,tipodebeca;
    
    
        do{
        	try{
        	System.out.println("MENU PRINCIPAL");
        	System.out.println("1.altas");
        	System.out.println("2.bajas");
        	System.out.println("3.cambios");
        	System.out.println("4.consultas");
        	System.out.println("5.salir");
        	System.out.println("Elige tu opcion");
        	opc=lec.leerEntero();
        	}catch(NumberFormatException ex){
        		System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		opc=0;
        	 }
        	
        	switch(opc){
        		 case 1:
        		 	try{
        		 	    System.out.println("MENU ALTAS");
        		        System.out.println("1.agregar alumno de cuota");
        		        System.out.println("2.agregar alumno de beca");
        		        System.out.println("3.regresar al menu principal");
        		        System.out.println("Elige tu opcion");
        		        opc=lec.leerEntero();
        		     }catch(NumberFormatException ex){//si la opcion no es valida se regresa almenu principal
        		       System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		       opc=3;//se escoge la opcion 3
        	          }
        		        switch(opc){
        		        	case 1://agregar alumno de cuota
        		        	       int b=0;
        		        	do{
        		        		
        		        	    try{
        		        	       System.out.print("teclea el codigo: ");
        		        	       codigo = lec.leerEntero();
        		        	        b=1;
        		        	        }catch(NumberFormatException ex){
        		        	       	System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		        	       	b=0;
        		        	       }//fin de try-catch
        		        	       
        		        	       }while(b==0);//fin de do-while
        		        	      
        		        	      //encontrar codigos repetidos
        		        	       for(int i=0; i<cont_adc; i++){
        		        	        if(codigo==adc[i].regresarCodigo()){
        		        	        	System.out.println("Lo siento este codigo pertenece a otro alumno");
        		        	        	System.out.println("le generaremos uno nuevo: ");
        		        	        	System.out.println("su nuevo codigo es: "+(adc[i].codigo=adc[i].codigo+101));
        		        	          }//if
        		        	       }//for
        		        	       
        		        	       System.out.print("dame el nombre: ");
        		        	       nombre = lec.leerCadena();
        		        	       System.out.print("dame la carrera: ");
        		        	       carrera = lec.leerCadena();
        		        	       System.out.print("dame la cuota: ");
        		        	       cuota = lec.leerDoble();
        		        	       adc[ind_adc]=new AlumnoDeCuota(codigo,nombre,carrera,cuota);
        		        	       ind_adc++; cont_adc++; cont_gen++;
        		        	       
        		        	    
        		        	       //impedir dar de alta mas alumnos
        		        	       if(ind_adc>8 && cont_adc>8){
        		        	       	System.out.print("Lo siento se ha alcanzado el maximo de alumnos de cuota\n");
        		        	       }
        		        	       
        		        	break;//case 1 agregar alumno de cuota
        		        	//agregar alumno de beca
        		        	case 2:
        		        	  do{
        		        	   try{
        		        		   System.out.print("teclea el codigo: ");
        		        	       codigo = lec.leerEntero();
        		        	       b=1;
        		        	        }catch(NumberFormatException ex){
        		        	       	System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		        	       	b=0;
        		        	       }//fin de try-catch 
        		        	       	
        		        	       }while(b==0);//fin de do-while
        		        	       
        		        	       //encontrar codigos repetidos
        		        	       for(int i=0; i<cont_adb; i++){
        		        	        if(codigo==adb[i].regresarCodigo()){
        		        	        	System.out.println("Lo siento este codigo pertenece a otro alumno");
        		        	        	System.out.println("le generaremos uno nuevo: ");
        		        	        	System.out.println("su nuevo codigo es: "+(adb[i].codigo=adb[i].codigo+101));
        		        	          }//if
        		        	       }//for
        		        	       	     
        		        	       System.out.print("dame el nombre: ");
        		        	       nombre = lec.leerCadena();
        		        	       System.out.print("dame la carrera: ");
        		        	       carrera = lec.leerCadena();
        		        	       System.out.print("dame el tipo de beca: ");
        		        	       tipodebeca = lec.leerCadena();
        		        	       adb[ind_adb]=new AlumnoDeBeca(codigo,nombre,carrera,tipodebeca);
        		        	       ind_adb++; cont_adb++; cont_gen++;
        		        	       
        		        	       //impedir dar de alta mas alumnos
        		        	       if(ind_adb>8 && cont_adb>8){
        		        	       	System.out.print("Lo siento se ha alcanzado el maximo de alumnos de beca\n");
        		        	       }
        		        	       
        		        	break;//case 2-altas
                            case 3: break;//regresa a menu principal
        		        }//switch-menu altas
        		  break;//case 1-altas
        	   
        	   //bajas para los alumnos	  
        	   case 2:int b=0;
        	   	do{
        	   	 try{
        	   	    System.out.print("dame el codigo del alumno para dar de baja: ");
                    codigo=lec.leerEntero(); 
                    b=1;
        		   }catch(NumberFormatException ex){
        		      System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		      b=0;
        		     }//fin de try-catch 
        		   }while(b==0);//fin de do-while
        		   
        		   //busca alumno para dar de baja (en alumnos de cuota)
        	   	    for(int i=0; i<cont_adc; i++){
        	   	  	 if(codigo==adc[i].regresarCodigo()){
                         System.out.println("Se ha dado de baja al alumno: ");
        	   	         adc[i].mostrarAlumno();
        	   	         adc[i].mostrarCuotaSemestral();
        	   	         adc[i]=adc[i+1];
        	   	         ind_adc--;
                         cont_adc--;
                       }//if
                      }//for
                      
                  //busca alumno para dar de baja (en alumnos de beca)   
                  for(int i=0; i<cont_adb; i++){
        	   	  if(codigo==adb[i].regresarCodigo()){
        	   	      System.out.println("Se ha dado de baja al alumno: ");
        	   	      adb[i].mostrarAlumno();
        	   	      adb[i].mostrarTipoDeBeca();
        	   	      adb[i]=adb[i+1];
        	   	      ind_adb--;
                      cont_adb--;
        	   	    }//if
        	   	  }//for
                  
                     
        	   break;//case-2_bajas
        	   
        	   //cambios para alumnos
        	   case 3: 
        	   do{
        	     try{
        	     System.out.print("dame el codigo del alumno a buscar (para corregir datos): ");
                 codigo=lec.leerEntero();
                  b=1;
        		  }catch(NumberFormatException ex){
        		      System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		      b=0;
        		     }//fin de try-catch 
        		   }while(b==0);//fin de do-while
                 
                 //busca alumno para dar de baja (en alumnos de cuota) 
        	   	 for(int i=0; i<cont_adc; i++){
        	   	 	if(codigo==adc[i].regresarCodigo()){
                      adc[i].mostrarAlumno();
                      adc[i].mostrarCuotaSemestral();
                      if(codigo==adc[i].codigo){
                       
                       //cambios para alumnos de cuota
                       try{
                       	System.out.println("MENU DE CAMBIOS PARA ALUMNOS DE CUOTA ADC");
                      	System.out.println("1.mod: codigo");
                      	System.out.println("2.mod: nombre");
                      	System.out.println("3.mod: carrera");
                      	System.out.println("4.mod: cuota semestral");
                      	System.out.println("5.regresar al menu principal");
                      	System.out.println("Elige tu opcion");
                      	opc=lec.leerEntero();
                      	}catch(NumberFormatException ex){
        		           System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		           opc=0;
        		     }//fin de try catch
        		     
                      	switch(opc){
                      		case 1: 
                      		 do{
                      		   try{
                      		    System.out.print("teclee el nuevo codigo para el alumno: ");
                      			adc[i].codigo=lec.leerEntero();
                      			b=1;
                      			}catch(NumberFormatException ex){
        		                 System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		                 b=0;
        		              }//fin de try-catch 
        		           }while(b==0);//fin de do-while
                      		break;//fin case-1
                      		
                      		case 2: 
                      			System.out.print("teclee el nuevo nombre para el alumno: ");
                      			adc[i].nombre=lec.leerCadena();
                      		break;//fin case-2
                      		case 3:
                      			System.out.print("teclee la nueva carrera para el alumno: ");
                      			adc[i].carrera=lec.leerCadena();
                      		break;//fin case-3		
                      		case 4:
                      			System.out.print("teclee la nueva cuota semestral para el alumno: ");
                      			adc[i].cuotasemestral=lec.leerDoble();
                      		break;//fin case-4
                      		case 5: opc=0;
                      		break;//fin case-5 ADC	        
                      	}//fin-switch para cambios
                     }//if anidado
                   }//if
        	   	 }//for 
        	   	 
        	   	 //busca alumno para dar de baja (en alumnos de beca)
        	   	 for(int i=0; i<cont_adb; i++){
        	   	  if(codigo==adb[i].regresarCodigo()){
        	   	  	adb[i].mostrarAlumno();
                    adb[i].mostrarTipoDeBeca();
                     if(codigo==adb[i].codigo){
                     
                       // cambios para alumnos de beca
                     	try{
                     	  System.out.println("MENU DE CAMBIOS PARA ALUMNOS DE BECA ADB");
                      	  System.out.println("1.mod: codigo");
                          System.out.println("2.mod: nombre");
                      	  System.out.println("3.mod: carrera");
                      	  System.out.println("4.mod: beca");
                      	  System.out.println("5.regresar al menu principal");
                      	  System.out.println("Elige tu opncion");
                      	  opc=lec.leerEntero();
                      	  }catch(NumberFormatException ex){
        		           System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		           opc=5;
        		       }//fin de try catch
        		       
                      	 switch(opc){
                      	 	case 1:
                      	 	 do{
                      	 	   try{
                      	 	    System.out.print("teclee el nuevo codigo para el alumno: ");
                      			adb[i].codigo=lec.leerEntero();
                      			b=1;
                      		   }catch(NumberFormatException ex){
        		                 System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		                 b=0;
        		              }//fin de try-catch 
        		           }while(b==0);//fin de do-while
                      			
                      	 	break;//fin case-1
                      	 	case 2:
                      	 		System.out.print("teclee el nuevo nombre para el alumno: ");
                      			adb[i].nombre=lec.leerCadena();
                      		break;//fin case-2
                      		case 3:
                      			System.out.print("teclee la nueva carrera para el alumno: ");
                      			adb[i].carrera=lec.leerCadena();
                      		break;//fin case-3
                      		case 4:	
                      			System.out.print("teclee el nuevo tipo de beca: ");
                      			adb[i].tipodebeca=lec.leerCadena();
                      		break;//fin case-4 
                      		case 5: opc=0;
                      		break;//fin case-5
                      	 }//fin switch para cambios ADB
                      }//if anidado
        	   	   }//if
        	   	}//for
        	   break;//case-3 cambios
        	   
        	   
        	   
        	   //consultas
               case 4:
               	    try{
               	      System.out.println("MENU CONSULTAS");
                      System.out.println("1.consultas individuales");
                      System.out.println("2.consultas generales para ADC");
                      System.out.println("3.consultas generales para ADB");
                      System.out.println("4.regresar al menu principal");
                      System.out.println("Elige tu opcion");
                      opc=lec.leerEntero();
                     }catch(NumberFormatException ex){
        		           System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		           opc=4;
        		     }//fin de try catch
                      switch(opc){
                      	//consultas individuales
                      	   case 1:
                      	   	 do{
                      	   	   try{
                      	   	      System.out.print("dame el codigo del alumno a buscar: ");
                      	          codigo=lec.leerEntero();
                      	          b=1;
                      	        }catch(NumberFormatException ex){
        		                 System.out.println("Lo siento, caracter no valido, trata de nuevo");
        		                 b=0;
        		              }//fin de try-catch 
        		           }while(b==0);//fin de do-while
        		           
                      	          //buscador de alumnos de cuota
                      	          for(int i=0; i<cont_adc; i++){
                      	          	if(codigo==adc[i].regresarCodigo()){
                      	          		adc[i].mostrarAlumno();
                      	          		adc[i].mostrarCuotaSemestral();
                      	          		}//if
                      	          	}//for
                      	          	
                      	         //buscador de alumnos de beca 	
                      	         for(int j=0; j<cont_adb; j++){
                      	          if(codigo==adb[j].regresarCodigo()){
                      	          		adb[j].mostrarAlumno();
                      	          		adb[j].mostrarTipoDeBeca();
                      	          	}//fin if 
                      	         }//for 
                      	    break;//case 1-consultas individuales
                        
                         //consultas generales para alumnos de cuota 
                          case 2: 
                          	//ORDENAR LOS ALUMNOS DE CUOTA POR CODIGO
                          	for(int i=0; i<cont_adc; i++){
                          	       for(int j=0; j<cont_adc-1; j++){
                          	      	if(adc[j].codigo>adc[j+1].codigo){
                          	      		aux=adc[j].codigo;
                          	      		adc[j].codigo=adc[j+1].codigo;
                          	      		adc[j+1].codigo=aux;
                          	      	}//if
                          	      }//for anidado
                               }//for
                          	System.out.println("ESTOS SON LOS ALUMNOS DE CUOTA");
                          	      for(int i=0;i<cont_adc;i++){
                          	      adc[i].mostrarAlumno();
                      	          adc[i].mostrarCuotaSemestral();
                      	          System.out.println("_");
                                  }//for
                                  opc=4;
                                  
                          break;// case 2-consultas generales ADC
                        
                        //consultas generales paras alumnos de beca
                        case 3:
                        	//ORDENAR LOS ALUMNO DE DE BECA POR CODIGO 
                             for(int i=0; i<cont_adb; i++ ){
                          	       for(int j=0; j<cont_adb-1; j++){
                          	       	if(adb[j].codigo>adb[j+1].codigo){
                          	       		aux=adb[j].codigo;
                          	       		adb[j].codigo=adb[j+1].codigo;
                          	       		adb[j].codigo=aux;
                          	       	}//iif
                          	     }//for
                             }//for
                          	System.out.println("ESTOS SON LOS ALUMNOS DE BECA");
                          	      for(int i=0;i<cont_adb;i++){
                          	      adb[i].mostrarAlumno();
                      	          adb[i].mostrarTipoDeBeca();
                      	          System.out.println("_");
                                  }//for 
                                  opc=4;
                          break;//case 3-consultas genrales ADB 
                          
                          case 4: break;//regresa al menu principal       	
                        }//switch consultas
              break;//case 4-consultas
              //fin programa
              
              case 5:
              	     System.out.println("GRACIAS FUE UN PLACER ATENDERTE"); 
              break;//fin case-5
         }//switch-menu principal

     }while(opc>=0 && opc<=4);



    }//main
}//clase Alumno


/************* Subclase ****************/
class AlumnoDeCuota extends Alumno{
	//atributo
	double cuotasemestral;

	//constructor
	public AlumnoDeCuota(int codigo,String nombre,String carrera,double cuotasemestral){
		super(codigo,nombre,carrera);//llamando al constructor de la superclase
		this.cuotasemestral=cuotasemestral;
	}

	public void mostrarCuotaSemestral(){
		System.out.println("CUOTA SEM    = "+cuotasemestral);
	}
}//clase AlumnoDeCuota

/************* Subclase ****************/
class AlumnoDeBeca extends Alumno{
	//atributo
	String tipodebeca;

	//constructor
	public AlumnoDeBeca(int codigo,String nombre,String carrera,String tipodebeca){
		super(codigo,nombre,carrera);//llamando al constructor de la superclase
		this.tipodebeca=tipodebeca;
	}

	public void mostrarTipoDeBeca(){
		System.out.println("TIPO DE BECA = "+tipodebeca);
	}
}//clase AlumnoDeBeca