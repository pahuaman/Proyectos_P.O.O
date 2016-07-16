/**
 * @(#)Alumno visual.java
 * @Equipo No. 2
 * @
 * @Integrantes:
 * @Bautista López Miguel Angel
 * @Garfia Pahua Jose G.
 * @Jiménez Pelayo Misael Antonio
 * @Peña Curiel Miguel Angel
 * @
 * @Seccion D09
 * @
 * @Calendario 2014A
 * @
 * @version 1.00 2014/6/5
 */
 import java.awt.*;
 import java.awt.event.*;
 
 import javax.swing.*;


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
        

    //familia de metodos regresar
    public int regresarCodigo(){
    	return codigo;
    }
    public String regresarNombre(){
    	return nombre;
    }
    public String regresarCarrera(){
    	return carrera;
    }
    
    //familia de metodos modificar
    public void modificarCodigo(int c){
    	codigo=c;
    }
    
    public void modificarNombre(String c){
    	nombre=c;
    }
    
    public void modificarCarrera(String c){
    	carrera=c;
    }



    

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

	public void modificarCuota(double p){
		cuotasemestral=p;
	}
	public double regresarCuota(){
    	return cuotasemestral;
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

		public void modificarBeca(String b){
		tipodebeca=b;
	}
	public String regresarBeca(){
    	return tipodebeca;
    }
}//clase AlumnoDeBeca



public class AlumnoVisual extends WindowAdapter implements ActionListener {
	//arreglos de referencias
        AlumnoDeCuota adc[]=new AlumnoDeCuota[10];
        AlumnoDeBeca  adb[]=new AlumnoDeBeca [10];
        //variables
        int opc=0, codigo=0, ind_adc=0, cont_adc=-1, ind_adb=0, cont_adb=-1, bandera=0, icont, posCambio;
        //opc=codigo=ind_adc=cont_adc=ind_adb=cont_adb=0;
        double cuota=0.0;
        String nombre, carrera, tipodebeca;
        String texto="";
        //Error cupos llenos
        Frame errorCupos;
        Label errCupos;
        Button okErrCupos;

        //Menu registro de alumnos
        Frame f;
        Button c;
        Button a;
        Button b;
        Button ca;
        Button s;
        //sub-Menu altas
        Frame A, aviso, errorNoInsrt;
        Button ab;
        Button ac;
        Button rm;
        Label avi, errNoInsrt;
        Button ok, okErrNoInsrt;
        //seccion altas alumno de cuota
        Frame Aac;
        Label Lcod, Lnom, Lcar, Lcuo;
        TextField TFcod, TFnom, TFcar, TFcuo;
        Button regis,reg;
        //seccion altas alumno de beca
        Frame Aab;
        Label Lcodb, Lnomb, Lcarb, Ltbec;
        TextField TFcodb, TFnomb, TFcarb, TFtbec;
        Button regisbec,regbec;
        //sub-Menu bajas
        Frame B, avisoBj, errorNOExst;
        Button ba, regBj;
        TextField N;
        Label t;
        Label aviBj, errNoExst;
        Button okBj, okErrNoExst, okErrNoExstCbs;
        //sub-Menu cambios
        Frame CA;
        Label Cb;
        TextField in;
        Button bu;
        Button sa;
        //ventana de cambios
        Frame cbs;
        Label Cod, Nom, Car, Cuo, Bec;
        Label nvoCod, nvoNom, nvoCar, nvoCuo, nvoBec;
        TextField tf1, tf2, tf3, tf4, tf5,tf6,tf7,tf8;
        Button cmb, regVcbs; 
        //sub-Menu consultas
        Frame CO;
        Button i;
        Button gc;
        Button gb;
        Button regCon;

        //menu consulta-individual
        Frame ci;
        Label zo;
        TextField w;
        Button z;
        Button x;
        //mostrar consulta individual
        Frame consInd;
        Label lCI1, lCI2, lCI3,lCI4, lCI5;
        TextField tfCI1, tfCI2,tfCI3,tfCI4;
        Button regCI;
        //Tablas
        Frame muestraGeneral;
        JTextArea muestraGen;
        Button regGc;
        
        
        
 public AlumnoVisual() {
 	    //Error cupos llenos
        errorCupos = new Frame("Error!!!");
        errCupos = new Label("Cupos llenos");
        okErrCupos = new Button("OK");
 	    //Menu registro de alumnos
    	f=new Frame("Registro de alumnos");
        c=new Button("Consultas");
        a=new Button("Altas");
        b=new Button("Bajas");
        ca=new Button("Cambios");
        s=new Button("Salir");
        //sub-Menu altas
        A=new Frame("Menu Altas");
 		ac=new Button("Alumno de cuota");
 		ab=new Button("Alumno de beca");
 		rm=new Button("Regresar");
 		//aviso alumno registrado correctamente
 		aviso = new Frame("Aviso!!!");
 		avi = new Label("Alumno registrado correctamente");
 		ok = new Button("OK");
 		//error no se han insertado datos
 		errorNoInsrt = new Frame("ERROR!!!");
 		errNoInsrt = new Label("No se han insertado datos");
 		okErrNoInsrt = new Button("OK");
 		//seccion alta alumno de cuota
 		Aac = new Frame("Alta alumno de cuota");
 		Lcod = new Label("Escribe tu codigo:");
 		Lnom = new Label("Escribe tu nombre:");
 		Lcar = new Label("Escribe tu carrera:");
 		Lcuo = new Label("Escribe tu cuota:");
 		TFcod = new TextField(30);
 		TFnom = new TextField(30);
 		TFcar = new TextField(30);
 		TFcuo = new TextField(30);
 		regis = new Button("Registrar");
 		reg = new Button("Regresar");
 		//seccion alta alumno de beca
 		Aab = new Frame("Alta alumno de beca");
 		Lcodb = new Label("Escribe tu codigo:");
 		Lnomb = new Label("Escribe tu nombre:");
 		Lcarb = new Label("Escribe tu carrera:");
 		Ltbec = new Label("Escribe tu tipo de beca:");
 		TFcodb = new TextField(30);
 		TFnomb = new TextField(30);
 		TFcarb= new TextField(30);
 		TFtbec = new TextField(30);
 		regisbec = new Button("Registrar");
 		regbec = new Button("Regresar");
 		//sub-Menu bajas
 		B=new Frame("Bajas de alumnos");
 		ba=new Button("Baja");
 		t=new Label("Codigo: ");
 		N=new TextField();
 		regBj = new Button("Regresar");
 		//error alumno no encontrado
 		errorNOExst= new Frame("Error!!!");
 		errNoExst = new Label("El alumno no fué encontrado");
 		okErrNoExst = new Button("OK");
 		okErrNoExstCbs = new Button("OK");
 		//aviso alumno eliminado correctamente
 		avisoBj= new Frame("Aviso!!!");
 		aviBj = new Label("Alumno dado de baja correctamente");
 		okBj = new Button("OK");
 		//sub-Menu cambios
        CA=new Frame("Cambios para alumnos");
        Cb=new Label("Teclee codigo: ");
        in=new TextField();
        bu=new Button("Buscar");
        sa=new Button("Regresar");
        
        //ventana de cambios
        cbs = new Frame("Realize los cambios");
        Cod = new Label("Codigo:"); 
        Nom = new Label("Nombre:");
        Car = new Label("Carrera:");
        Cuo = new Label("Codigo:");
        Bec = new Label("Codigo:");
        nvoCod = new Label("Nuevo Codigo:");
        nvoNom = new Label("Nuevo Nombre:");
        nvoCar = new Label("Nueva Carrera:");
        nvoCuo = new Label("Nueva Cuota:");
        nvoBec = new Label("Nueva Beca:");        
        tf1 = new TextField(30);
        tf2 = new TextField(30);
        tf3 = new TextField(30);
        tf4 = new TextField(30);
        tf5 = new TextField(30);
        tf6 = new TextField(30);
        tf7 = new TextField(30);
        tf8 = new TextField(30);
        cmb = new Button("Cambio");
        regVcbs = new Button("Regresar");         
        //sub-Menu consultas
        CO=new Frame("Consultas");
        i=new Button("Individuales");
        gc=new Button("Generales de cuota");
        gb=new Button("Generales de beca");
        regCon= new Button("Regresar");

        //menu consulta individual
        ci=new Frame("Consulta individual");
        zo=new Label("Teclee codigo: ");
        w=new TextField();
        z=new Button("Buscar");
        x=new Button("Regresar");
        //mostrar consulta individual
        consInd = new Frame("Mostrando su consulta individual");        
        lCI1 = new Label("Codigo:");
        lCI2 = new Label("Nombre:");
        lCI3 = new Label("Carrera:");
        lCI4 = new Label("Cuota:");
        lCI5 = new Label("Beca:");
        tfCI1 = new TextField(30);
        tfCI2 = new TextField(30);
        tfCI3 = new TextField(30);
        tfCI4 = new TextField(30);
        regCI = new Button("Regresar");
        //Tablas
        muestraGeneral = new Frame("Mostrando datos");
        muestraGen = new JTextArea(10, 4);
        regGc = new Button("Regresar");    	

       }//Fin -  metodo constructor
       

 public void mostrarMarco(){
 	//Error cupos llenos
 		errorCupos.addWindowListener(this);//oreja
        errorCupos.setLayout(new GridLayout(2,1));
        errorCupos.add(errCupos);
        errorCupos.add(okErrCupos);
        errorCupos.setBounds(400,250,300,100);
        errorCupos.setResizable(false);
        errorCupos.setVisible(false);
        okErrCupos.addActionListener(this);
 	//Ventana menú registro de alumnos
 	f.setLayout(new GridLayout(5,0));
 	f.add(a);
 	f.add(b);
 	f.add(ca);
 	f.add(c);
 	f.add(s);
 	f.setBounds(400,250,300,150);//x,y,width,height
    f.setResizable(false);
    f.setVisible(true);
    f.addWindowListener(this);
    a.addActionListener(this);
    b.addActionListener(this);
    ca.addActionListener(this);
    c.addActionListener(this);
    s.addActionListener(this);
    //Ventana menú altas
    A.setLayout(new GridLayout(3,0));
 	A.add(ac);
 	A.add(ab);
 	A.add(rm);
    A.setBounds(400,250,300,150);//x,y,width,height
    A.setResizable(false);
    A.setVisible(false);
    A.addWindowListener(this);
    ab.addActionListener(this);
    ac.addActionListener(this);
    rm.addActionListener(this);
    //AVISO!!- insertado correctamente
    aviso.addWindowListener(this);//oreja
    aviso.setLayout(new GridLayout (2,1));
    aviso.setBounds(400,250,300,100);
    aviso.add(avi);
    aviso.add(ok);
    aviso.setVisible(false);
    aviso.setResizable(false);
    ok.addActionListener(this);
    //error no se han insertado datos
    errorNoInsrt.addWindowListener(this);//oreja
    errorNoInsrt.setLayout(new GridLayout (2,0));
    errorNoInsrt.setBounds(400,250,300,100);
    errorNoInsrt.add(errNoInsrt);
    errorNoInsrt.add(okErrNoInsrt);
    errorNoInsrt.setVisible(false);
    errorNoInsrt.setResizable(false);
    okErrNoInsrt.addActionListener(this);
    //seccion alta alumno de cuota
    	Aac.addWindowListener(this);//oreja
 		Aac.setLayout(new GridLayout(5,2));
 		Aac.setBounds(400,250,300,150);
 		Aac.add(Lcod);
 		Aac.add(TFcod);
 		Aac.add(Lnom);
 		Aac.add(TFnom);
 		Aac.add(Lcar);
 		Aac.add(TFcar);
 		Aac.add(Lcuo);
 		Aac.add(TFcuo);
 		Aac.add(regis);
 		Aac.add(reg);
 		Aac.setResizable(false);
        Aac.setVisible(false);
        Aac.addWindowListener(this);
        regis.addActionListener(this);
        reg.addActionListener(this);
    //seccion alta alumno de beca
    	Aab.addWindowListener(this);//oreja
 		Aab.setLayout(new GridLayout(5,2));
 		Aab.setBounds(400,250,300,150);
 		Aab.add(Lcodb);
 		Aab.add(TFcodb);
 		Aab.add(Lnomb);
 		Aab.add(TFnomb);
 		Aab.add(Lcarb);
 		Aab.add(TFcarb);
 		Aab.add(Ltbec);
 		Aab.add(TFtbec);
 		Aab.add(regisbec);
 		Aab.add(regbec);
 		Aab.setResizable(false);
        Aab.setVisible(false);
        Aab.addWindowListener(this);
        regisbec.addActionListener(this);
        regbec.addActionListener(this);

    //Ventana menú bajas
    B.addWindowListener(this);//oreja
    B.setLayout(new GridLayout(2,2));
    B.add(t);
    B.add(N);
    B.add(ba);
    B.add(regBj);
    B.setBounds(400,250,300,150);//x,y,width,height
    B.setResizable(false);
    B.setVisible(false);
    ba.addActionListener(this);
    regBj.addActionListener(this);
    //error alumno no encontrado
    	errorNOExst.addWindowListener(this);//oreja
 		errorNOExst.setLayout(new GridLayout(2,1));
 		errorNOExst.setBounds(400,250,300,100);
 		errorNOExst.add(errNoExst);
 		errorNOExst.add(okErrNoExst);
 		okErrNoExst.addActionListener(this);
 		okErrNoExstCbs.addActionListener(this);
 		//aviso alumno eliminado correctamente
 		avisoBj.addWindowListener(this);//oreja
 		avisoBj.setLayout(new GridLayout(2,1));
 		avisoBj.setBounds(400,250,300,100);
 		avisoBj.add(aviBj);
 		avisoBj.add(okBj);
 		okBj.addActionListener(this);

    //Ventana menú cambios
    CA.addWindowListener(this);//oreja
    CA.setLayout(new GridLayout(2,2));
    CA.add(Cb);
    CA.add(in);
    CA.add(bu);
    CA.add(sa);
    CA.setBounds(400,250,300,150);//x,y,width,height
    CA.setResizable(false);
    CA.setVisible(false);
    sa.addActionListener(this);
    bu.addActionListener(this);
    ca.addActionListener(this);
    //Ventana menú consultas
	CO.addWindowListener(this);//oreja
    CO.setLayout(new GridLayout(4,1));
 	CO.add(i);
 	CO.add(gc);
 	CO.add(gb);
 	CO.add(regCon);
    CO.setBounds(400,250,300,150);//x,y,width,height
    CO.setResizable(false);
    CO.setVisible(false);
    i.addActionListener(this);
    gc.addActionListener(this);
    gb.addActionListener(this);
    regCon.addActionListener(this);

     //sub-menu consulta individual
    ci.addWindowListener(this);//oreja 
    ci.setLayout(new GridLayout(2,2));
    ci.add(zo);
    ci.add(w);
    ci.add(z);
    ci.add(x);
    ci.setBounds(400,250,300,150);//x,y,width,height
    ci.setResizable(false);
    ci.setVisible(false);
    z.addActionListener(this);
    x.addActionListener(this);
    
    regGc.addActionListener(this);


}

 public void actionPerformed(ActionEvent ae){
 	//Accion en boton menu principal
 	if(ae.getSource()==a){
       A.setVisible(true);
      f.setVisible(false);
      

	}
 	else if(ae.getSource()==b){
 		if (cont_adb>-1 || cont_adc>-1){
 			B.setVisible(true);
 		f.setVisible(false);
 		}else
 			errorNoInsrt.setVisible(true);
 	}
 	else if(ae.getSource()==ca){
 		if (cont_adb>-1 || cont_adc>-1){
 			CA.setVisible(true);
 			f.setVisible(false);
 		}else
 			errorNoInsrt.setVisible(true);

  	}
 	else if(ae.getSource()==c){
 		if (cont_adb>-1 || cont_adc>-1){
 			CO.setVisible(true);
 			f.setVisible(false);
 		}else
 			errorNoInsrt.setVisible(true);
 	}
 	else if(ae.getSource()==s){
 		System.exit(0);
 	}
 	//Accion en boton menu altas
 	if(ae.getSource()==ac){
       Aac.setVisible(true);
       A.setVisible(false);
	}
 	else if(ae.getSource()==ab){
       	 A.setVisible(false);
         Aab.setVisible(true);
    }
    else if(ae.getSource()==rm){
       	 A.setVisible(false);
         f.setVisible(true);
    }
    else if(ae.getSource()==ok){
    	aviso.setVisible(false);
    }
    else if(ae.getSource()==okErrNoInsrt){
    	errorNoInsrt.setVisible(false);
    }
    //Accion en boton alta alumno de cuota
    if(ae.getSource()==regis){
    	if(cont_adc<9){
    	bandera=0;
    	try{
        	codigo=Integer.parseInt(TFcod.getText());
        }
        catch(Exception codigoError){
        	bandera=1;
        }

 		nombre=TFnom.getText();
 		carrera=TFcar.getText();

 		try{
        	cuota=Double.parseDouble(TFcuo.getText());
        }catch(Exception codigoError){
        	if(bandera==0)
        	bandera=2;
        	if(bandera==1)
        	bandera=3;
        }

        if(bandera==0){
        bandera=0;
        for(icont=0; icont<cont_adc;icont++){
		    if(codigo==adc[icont].regresarCodigo()){
				bandera=1;
			}//if
		}//for
		for(icont=0;icont<cont_adb;icont++){
			if(codigo==adb[icont].regresarCodigo()){
				bandera=1;
			}//if
		}//for

		if(bandera==0){
		if(cont_adc==-1){
        	ind_adc=cont_adc=0;
        }
    	adc[ind_adc] = new AlumnoDeCuota(codigo, nombre, carrera, cuota);
    	ind_adc++;
    	cont_adc++;
    	TFcod.setText("");
    	TFnom.setText("");
    	TFcar.setText("");
    	TFcuo.setText("");
    	aviso.setVisible(true);
		}else if(bandera==1){
			TFcod.setText("Este codigo ya existe");
    	    TFnom.setText(nombre);
    	    TFcar.setText(carrera);
    	    TFcuo.setText(Double.toString(cuota));
		}
        }else if(bandera==1){
        	TFcod.setText("Error! tiene que ser numerico");
        	TFnom.setText(nombre);
        	TFcar.setText(carrera);
        	TFcuo.setText(Double.toString(cuota));
        }
        else if(bandera==2){
        	TFcod.setText(Integer.toString(codigo));
        	TFnom.setText(nombre);
        	TFcar.setText(carrera);
        	TFcuo.setText("Error! tiene que ser numerico");
        }
        else if(bandera==3){
        	TFcod.setText("Error! tiene que ser numerico");
        	TFnom.setText(nombre);
        	TFcar.setText(carrera);
        	TFcuo.setText("Error! tiene que ser numerico");
        }
    }else{
    	Aac.setVisible(false);
    	f.setVisible(true);
    	errorCupos.setVisible(true);

    }
	}//fin- accion en boton alumno de cuota
	else if(ae.getSource()==okErrCupos){
		errorCupos.setVisible(false);
	}
 	else if(ae.getSource()==reg){
       	 Aac.setVisible(false);
         A.setVisible(true);
    }
    //Accion en boton alta alumno de beca
    if(ae.getSource()==regisbec){
    	if(cont_adb<9){
    	bandera=0;
    	try{
        	codigo=Integer.parseInt(TFcodb.getText());
        }
        catch(Exception codigoError){
        	bandera=1;
        }

 		nombre=TFnomb.getText();
 		carrera=TFcarb.getText();
 		tipodebeca=TFtbec.getText();

        if(bandera==0){
        bandera=0;
        for(icont=0; icont<cont_adc;icont++){
		    if(codigo==adc[icont].regresarCodigo()){
				bandera=1;
			}//if
		}//for

		for(icont=0;icont<cont_adb;icont++){
			if(codigo==adb[icont].regresarCodigo()){
				bandera=1;
			}//if
		}//for

		if(bandera==0){
		if(cont_adb==-1){
        	ind_adb=cont_adb=0;
        }
    	adb[ind_adb] = new AlumnoDeBeca(codigo, nombre, carrera, tipodebeca);
    	ind_adb++;
    	cont_adb++;
    	TFcodb.setText("");
    	TFnomb.setText("");
    	TFcarb.setText("");
    	TFtbec.setText("");
    	aviso.setVisible(true);
		}else if(bandera==1){
			TFcodb.setText("Este codigo ya existe");
    	    TFnomb.setText(nombre);
    	    TFcarb.setText(carrera);
    	    TFtbec.setText(tipodebeca);
		}
        }else if(bandera==1){
        	TFcodb.setText("Error! tiene que ser numerico");
        	TFnomb.setText(nombre);
        	TFcarb.setText(carrera);
        	TFtbec.setText(tipodebeca);
        }
        }else{
    	Aac.setVisible(false);
    	f.setVisible(true);
    	errorCupos.setVisible(true);

    }
	}//fin - accione n boton alumno de beca
 	else if(ae.getSource()==regbec){
       	 Aab.setVisible(false);
         A.setVisible(true);
    }
    //Accion en boton menu bajas
    if(ae.getSource()==ba){
    	bandera=0;
    	try{
        	codigo=Integer.parseInt(N.getText());
        }
        catch(Exception codigoError){
        	bandera=1;
        }
        if(bandera==0){
        	bandera=0;
        	for(icont=0; icont<cont_adc;icont++){
				        	if(codigo==adc[icont].regresarCodigo()){
				        		do{
				        			adc[icont]=adc[icont+1];
				        			icont++;
				        		}while(icont<cont_adc);
				        		ind_adc--;
				        		cont_adc--;
				        		bandera=1;
				        	}//if
			}//for
			if(bandera==0){
				        	for(icont=0;icont<cont_adb;icont++){
				        		if(codigo==adb[icont].regresarCodigo()){
				        			do{
				        				adb[icont]=adb[icont+1];
				        				icont++;
				        			}while(icont<cont_adb);
				        			ind_adb--;
				        			cont_adb--;
				        			bandera=1;
				        		}
			    }//for
			}//if
			if(bandera==0){
				errorNOExst.setVisible(true);
			}else if(bandera==1){
				avisoBj.setVisible(true);
			}
        }else
        	N.setText("Error! tiene que ser numerico");

    }//boton ba
    else if(ae.getSource()==regBj){
    	f.setVisible(true);
    	B.setVisible(false);
    }//boton regBj
    else if(ae.getSource()==okBj){
    	avisoBj.setVisible(false);

    }
    else if(ae.getSource()==okErrNoExst){
    	errorNOExst.setVisible(false);
    }

    //Accion en boton menu cambios
    if(ae.getSource()==bu){//Busqueda para un cambio
    	bandera=0;
    	try{
        	codigo=Integer.parseInt(in.getText());
        }
        catch(Exception codigoError){
        	bandera=1;
        }
        if(bandera==0){
        	bandera=0;
        	for(icont=0; icont<cont_adc;icont++){
				        	if(codigo==adc[icont].regresarCodigo()){
				        		bandera=1;
				        		posCambio=icont;
				        	}//if
			}//for
			if(bandera==0){
				        	for(icont=0;icont<cont_adb;icont++){
				        		if(codigo==adb[icont].regresarCodigo()){
				        			bandera=2;
				        			posCambio=icont;
				        		}
			    }//for
			}//if
			if(bandera==0){
				errorNOExst.setVisible(true);
			}else if(bandera==1){
				cbs.removeAll();
				cbs.setLayout(new GridLayout(9 , 2));
				cbs.setBounds(400, 250, 300, 500);
				cbs.add(Cod);
				cbs.add(tf1);
				tf1.setText(Integer.toString(adc[posCambio].regresarCodigo()));
				cbs.add(Nom);
				cbs.add(tf2);
				tf2.setText(adc[posCambio].regresarNombre());
				cbs.add(Car);
				cbs.add(tf3);
				tf3.setText(adc[posCambio].regresarCarrera());
				cbs.add(Cuo);
				cbs.add(tf4);
				tf4.setText(Double.toString(adc[posCambio].regresarCuota()));
				cbs.add(nvoCod);
				cbs.add(tf5);
				cbs.add(nvoNom);
				cbs.add(tf6);
				cbs.add(nvoCar);
				cbs.add(tf7);
				cbs.add(nvoCuo);
				cbs.add(tf8);
				cbs.add(cmb);
				cbs.add(regVcbs);
				cbs.setVisible(true);
				cbs.setResizable(false);
				cmb.addActionListener(this);
				regVcbs.addActionListener(this);
				CA.setVisible(false);			
			}
			else if(bandera==2){
				cbs.removeAll();
				cbs.setLayout(new GridLayout(9 , 2));
				cbs.setBounds(400, 250, 300, 500);
				cbs.add(Cod);
				cbs.add(tf1);
				tf1.setText(Integer.toString(adb[posCambio].regresarCodigo()));
				cbs.add(Nom);
				cbs.add(tf2);
				tf2.setText(adb[posCambio].regresarNombre());
				cbs.add(Car);
				cbs.add(tf3);
				tf3.setText(adb[posCambio].regresarCarrera());
				cbs.add(Bec);
				cbs.add(tf4);
				tf4.setText(adb[posCambio].regresarBeca());
				cbs.add(nvoCod);
				cbs.add(tf5);
				cbs.add(nvoNom);
				cbs.add(tf6);
				cbs.add(nvoCar);
				cbs.add(tf7);
				cbs.add(nvoBec);
				cbs.add(tf8);
				cbs.add(cmb);
				cbs.add(regVcbs);
				cbs.setVisible(true);
				cbs.setResizable(false);
				cmb.addActionListener(this);
				regVcbs.addActionListener(this);
				CA.setVisible(false);
			}
        }else
        	in.setText("Error! tiene que ser numerico");

      }//fin - Busqueda para un cambio
      else if(ae.getSource()==cmb){//hacer el cambio
        if(bandera==1){
          	bandera=0;
    	try{
        	codigo=Integer.parseInt(tf5.getText());
        }
        catch(Exception codigoError){
        	bandera=1;
        }

 		nombre=tf6.getText();
 		carrera=tf7.getText();

 		try{
        	cuota=Double.parseDouble(tf8.getText());
        }catch(Exception codigoError){
        	if(bandera==0)
        	bandera=2;
        	if(bandera==1)
        	bandera=3;
        }
        if(bandera==0){
        bandera=0;
        for(icont=0; icont<cont_adc;icont++){
		    if(codigo==adc[icont].regresarCodigo()){
				bandera=1;
			}//if
		}//for
		for(icont=0;icont<cont_adb;icont++){
			if(codigo==adb[icont].regresarCodigo()){
				bandera=1;
			}//if
		}//for   

		if(bandera==0){		
    	adc[posCambio].modificarCodigo(codigo);
    	adc[posCambio].modificarNombre(nombre);
    	adc[posCambio].modificarCarrera(carrera);
    	adc[posCambio].modificarCuota(cuota);
    	cbs.setVisible(false);
    	CA.setVisible(true);
    	tf1.setText("");
    	tf2.setText("");
    	tf3.setText("");
    	tf4.setText("");
    	tf5.setText("");
    	tf6.setText("");
    	tf7.setText("");
    	tf8.setText("");
    	avi.setText("Cambio relizado correctamente!!!");
    	aviso.setVisible(true);
		}else if(bandera==1){
			tf5.setText("Este codigo ya existe");
    	    tf6.setText(nombre);
    	    tf7.setText(carrera);
    	    tf8.setText(Double.toString(cuota));
		}
        }else if(bandera==1){
        	tf5.setText("Error! tiene que ser numerico");
        	tf6.setText(nombre);
        	tf7.setText(carrera);
        	tf8.setText(Double.toString(cuota));
        }
        else if(bandera==2){
        	tf5.setText(Integer.toString(codigo));
        	tf6.setText(nombre);
        	tf7.setText(carrera);
        	tf8.setText("Error! tiene que ser numerico");
        }
        else if(bandera==3){
        	tf5.setText("Error! tiene que ser numerico");
        	tf6.setText(nombre);
        	tf7.setText(carrera);
        	tf8.setText("Error! tiene que ser numerico");
        }
          	
          }//fin - if(bandera ==1)
          if(bandera==2){
          	bandera=0;
    	try{
        	codigo=Integer.parseInt(tf5.getText());
        }
        catch(Exception codigoError){
        	bandera=1;
        }

 		nombre=tf6.getText();
 		carrera=tf7.getText();
 		tipodebeca=tf8.getText();
        if(bandera==0){
        bandera=0;
        for(icont=0; icont<cont_adc;icont++){
		    if(codigo==adc[icont].regresarCodigo()){
				bandera=1;
			}//if
		}//for
		for(icont=0;icont<cont_adb;icont++){
			if(codigo==adb[icont].regresarCodigo()){
				bandera=1;
			}//if
		}//for   

		if(bandera==0){		
    	adb[posCambio].modificarCodigo(codigo);
    	adb[posCambio].modificarNombre(nombre);
    	adb[posCambio].modificarCarrera(carrera);
    	adb[posCambio].modificarBeca(tipodebeca);
    	cbs.setVisible(false);
    	CA.setVisible(true);
    	tf1.setText("");
    	tf2.setText("");
    	tf3.setText("");
    	tf4.setText("");
    	tf5.setText("");
    	tf6.setText("");
    	tf7.setText("");
    	tf8.setText("");
    	avi.setText("Cambio relizado correctamente!!!");
    	aviso.setVisible(true);
		}else if(bandera==1){
			tf5.setText("Este codigo ya existe");
    	    tf6.setText(nombre);
    	    tf7.setText(carrera);
    	    tf8.setText(tipodebeca);
		}
        }else if(bandera==1){
        	tf5.setText("Error! tiene que ser numerico");
        	tf6.setText(nombre);
        	tf7.setText(carrera);
        	tf8.setText(tipodebeca);
        }        
        
          }//fin - if(bandera ==2) 	
      }//fin - hacer el cambio
      else if(ae.getSource()==regVcbs){
      	CA.setVisible(true);
      	cbs.setVisible(false);
      }
      if (ae.getSource()==sa){
      	CA.setVisible(false);
      	f.setVisible(true);
      }


    //Accion en boton menu consultas
    
  if(ae.getSource()==i){
      ci.setVisible(true);
      f.setVisible(false);
  }
  if(ae.getSource()==regCon){
      ci.setVisible(false);
      f.setVisible(true);
  }
    if(ae.getSource()==z){//if de consulta-individual
    	bandera=0;
    	try{
        	codigo=Integer.parseInt(w.getText());
        }
        catch(Exception codigoError){
        	bandera=1;
        }
        if(bandera==0){
        	        for(icont=0; icont<cont_adc;icont++){
            if(codigo==adc[icont].regresarCodigo()){
            	bandera=1;
            	posCambio=icont;
            }//if
        }//for

        for(icont=0;icont<cont_adb;icont++){
           if(codigo==adb[icont].regresarCodigo()){
           	bandera=2;
           	posCambio=icont;
           }
        }//for
        if(bandera==0){
        	errorNOExst.setVisible(true);
        }
        if (bandera==1){  
        consInd.removeAll();      	
        consInd.setLayout(new GridLayout(5, 2));
        consInd.setBounds(300, 300, 400, 250);        
        consInd.add(lCI1);
        consInd.add(tfCI1);
        tfCI1.setText(Integer.toString(adc[posCambio].regresarCodigo()));
        consInd.add(lCI2); 
        consInd.add(tfCI2);
        tfCI2.setText(adc[posCambio].regresarNombre());	
        consInd.add(lCI3);
        consInd.add(tfCI3); 
        tfCI3.setText(adc[posCambio].regresarCarrera());
        consInd.add(lCI4);        
        consInd.add(tfCI4);
        tfCI4.setText(Double.toString(adc[posCambio].regresarCuota()));
        consInd.add(regCI);
        regCI.addActionListener(this);
        consInd.setVisible(true);
        consInd.setResizable(false);
        }if(bandera==2){
        	consInd.removeAll();
        	consInd.setLayout(new GridLayout(5, 2));
        consInd.setBounds(300, 300, 400, 250);        
        consInd.add(lCI1);
        consInd.add(tfCI1);
        tfCI1.setText(Integer.toString(adb[posCambio].regresarCodigo()));
        consInd.add(lCI2); 
        consInd.add(tfCI2);
        tfCI2.setText(adb[posCambio].regresarNombre());	
        consInd.add(lCI3);
        consInd.add(tfCI3); 
        tfCI3.setText(adb[posCambio].regresarCarrera());
        consInd.add(lCI5);        
        consInd.add(tfCI4);
        tfCI4.setText(adb[posCambio].regresarBeca());
        consInd.add(regCI);
        regCI.addActionListener(this);
        consInd.setVisible(true);
        consInd.setResizable(false);
        	
        }
        }else{
        	w.setText("Debe ser numerico");
        }
     }//fin - if consulta individual
     if(ae.getSource()==regCI){
     	consInd.setVisible(false);
     	tfCI1.setText("");
     	tfCI2.setText("");
     	tfCI3.setText("");
     	tfCI4.setText("");
     }
     if(ae.getSource()==gc){
     	if(cont_adc!=-1){
     	muestraGeneral.removeAll();
     	CO.setVisible(false);
     	muestraGeneral.setLayout(new GridLayout(2,1));
     	muestraGeneral.setBounds(300,50,400,500);
     	texto="Codigo:\tNombre:\tCarrera:\tCuota:\n";     	
     	for(icont=0; icont<cont_adc; icont++){
     		
     		for(int jcont=0;jcont<4;jcont++){     			
     			 
     			 	if(jcont==0)
     			 	texto=texto+Integer.toString(adc[icont].regresarCodigo());
     			 	if(jcont==1)
     			 		texto=texto+adc[icont].regresarNombre();
     			 	if(jcont==2)
     			 		texto=texto+adc[icont].regresarCarrera();
     			 	if(jcont==3)
     			 		texto=texto+Double.toString(adc[icont].regresarCuota());
     			 
     			 texto=texto+"\t";
     			
     		}
     		texto=texto+"\n";
     	}
     	muestraGen.setText(texto);
        muestraGeneral.add(muestraGen);            
     	muestraGeneral.add(regGc);
     	muestraGeneral.setVisible(true);
        muestraGeneral.setResizable(false);
     	}else
     		errorNoInsrt.setVisible(true);
     }
     if(ae.getSource()==gb){
     	if(cont_adb!=-1){
     	muestraGeneral.removeAll();
     	CO.setVisible(false);
     	muestraGeneral.setLayout(new GridLayout(2,1));
     	muestraGeneral.setBounds(300,50,400,500);
     	texto="Codigo:\tNombre:\tCarrera:\tBeca:\n";     	
     	for(icont=0; icont<cont_adc; icont++){
     		
     		for(int jcont=0;jcont<4;jcont++){     			
     			 
     			 	if(jcont==0)
     			 	texto=texto+Integer.toString(adb[icont].regresarCodigo());
     			 	if(jcont==1)
     			 		texto=texto+adb[icont].regresarNombre();
     			 	if(jcont==2)
     			 		texto=texto+adb[icont].regresarCarrera();
     			 	if(jcont==3)
     			 		texto=texto+adb[icont].regresarBeca();
     			 
     			 texto=texto+"\t";
     			
     		}
     		texto=texto+"\n";
     	}
     	muestraGen.setText(texto);
        muestraGeneral.add(muestraGen);            
     	muestraGeneral.add(regGc);
     	muestraGeneral.setVisible(true);
        muestraGeneral.setResizable(false);
        }else
     		errorNoInsrt.setVisible(true);
     	
     }
      if(ae.getSource()==x){
      	CO.setVisible(true);
      	ci.setVisible(false);     	
     }
      if(ae.getSource()==regGc){
      	muestraGeneral.setVisible(false);
      	CO.setVisible(true);  
      	texto="";
      	muestraGen.setText(texto);   	
     }

   

 }//fin-action performed


 public void windowClosing(WindowEvent we){
 	//System.exit(0);
 	if(we.getSource()==errorCupos){
 		errorCupos.dispose();
 	}else if(we.getSource()==A){
 		A.dispose();
 	}else if(we.getSource()==aviso){
 		aviso.dispose();
 	}else if(we.getSource()==errorNoInsrt){
 		errorNoInsrt.dispose();
 	}else if(we.getSource()==Aac){
 		Aac.dispose();
 	}else if(we.getSource()==Aab){
 		Aab.dispose();
 	}else if(we.getSource()==B){
 		B.dispose();
 	}else if(we.getSource()==errorNOExst){
 		errorNOExst.dispose();
 	}else if(we.getSource()==avisoBj){
 		avisoBj.dispose();
 	}else if(we.getSource()==CA){
 		CA.dispose();
 	}else if(we.getSource()==CO){
 		CO.dispose();
 	}else if(we.getSource()==ci){
 		ci.dispose();
 	}else{System.exit(0);
 	}
 	
 }
    public static void main(String[] args) {
       AlumnoVisual z=new AlumnoVisual();
       z.mostrarMarco();
    }
}