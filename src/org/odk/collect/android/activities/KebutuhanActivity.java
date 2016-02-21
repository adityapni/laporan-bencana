package org.odk.collect.android.activities;






import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.odk.collect.android.R;
import org.odk.collect.android.application.Collect;
import org.odk.collect.android.logic.FormController;
import org.odk.collect.android.tasks.SaveToDiskTask;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.google.android.maps.GeoPoint;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

 
public class KebutuhanActivity extends Activity {
	
	public ViewFlipper flipper;
	private Animation slideLeftIn;
	private Animation slideLeftOut;
	private Animation slideRightIn;
	private Animation slideRightOut; 
	
	float xUp;
	float xDown;
	final Context context=this;
	Button mbutton;
	EditText medit1;
	EditText medit2;
	int bujur=0;
	int lintang=0;
	GeoPoint poskoA = new GeoPoint(0,150*(int)Math.pow(10,6));
	GeoPoint poskoB = new GeoPoint(0,148*(int)Math.pow(10,6));
	GeoPoint poskoinput;
	float[] resultsA = new float[1];
	float[] resultsB = new float[1];
	AlertDialog.Builder alert;
	String posisiposko="";
	 
	protected void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
        setContentView(R.layout.kebutuhan);
        int count;
        TextView TextViewKebutuhan = (TextView)findViewById(R.id.textViewKebutuhan);
        count=0;
        
        ListView listKebutuhan;
        listKebutuhan=(ListView)findViewById(R.id.listKebutuhan);
        
       
       flipper=(ViewFlipper)findViewById(R.id.viewFlipper1);
       
       
        String ODK_ROOT = Environment.getExternalStorageDirectory()
                + File.separator + "odk";
       
       slideLeftIn = AnimationUtils.loadAnimation(this, R.anim.push_left_in);
       
       slideLeftIn.setAnimationListener(new ScrollLeft());
       slideLeftOut = AnimationUtils.loadAnimation(this, R.anim.push_left_out);
       slideRightIn = AnimationUtils.loadAnimation(this, R.anim.push_right_in);
       slideRightIn.setAnimationListener(new ScrollRight());
       slideRightOut = AnimationUtils.loadAnimation(this, R.anim.push_right_out);
        String path = ODK_ROOT + File.separator + "instances";
       
        
            
       
        //File instancepath;
        //instancepath = formController.getInstancePath();

        for(nm nmvar : SAXParserDemo.getNmList()){
			//System.out.println("------------------------");
			//System.out.println("jenis :"+nmvar.getJenis());
			//System.out.println("tanggal :"+nmvar.getTanggal());        	
            for(repeat_observation rpo : nmvar.getAlRepeat()){
                //System.out.println("kecamatan :" +rpo.getKecamatan());
                //System.out.println("kelurahan desa :" +rpo.getKelurahanDesa());
                //System.out.println("kondisi korban :" +rpo.getKondisiKorban());
            	
            	if (rpo.getKondisiKorban() != null){
            	count = count+1;
                }
                System.out.println("------------------------");
            }
            
  //      }
        }
        
  		  int susububuk;int tepungbubur;int botolsusu;
  		  int perlengkapanbayi;int pampers;int pakaianbalita;
  		  int mpasi;int sarung;int pakaian;
  		  int tongkat;int biskuit;int suplemen;
  		  int beras;int ikanasin;int kecap;
  		  int sambal;int mie;int selimut;
  		  int kaosdewasa;int kaosanak;int seragamsdlk;
  		  int seragamsdp;int tandu;int tenda;
  		  int velbeth;int beko;int douser;
  		  int cangkul;int sekop;int infus;
  		  int perban;int kapas;int betadine;
  		  int abcair;int abampul;int bidak;
  	
  		
  		
       susububuk=count*3;
       tepungbubur=count*3;
       botolsusu=count*3;
       perlengkapanbayi=count;
       pampers=count*5;
       pakaianbalita=count;
       mpasi=count*3;
       sarung=count;
       pakaian=count;
       tongkat=count;
       biskuit=count;
       suplemen=count;
       beras=count;
       ikanasin=count*3;
       kecap=count;
       sambal=count;
       mie=count*3;
       selimut=count;
       kaosdewasa=count;
       kaosanak=count;
       seragamsdlk=count;
       seragamsdp=count;
       tandu=count;
       tenda=(int)Math.ceil(((double)count/(double)4));
       String[] values= new String[]{"susu bubuk :"+String.valueOf(susububuk),"tepung bubur: "+String.valueOf(tepungbubur),
    		   "botol susu: "+String.valueOf(botolsusu),"perlengkapan bayi:"+String.valueOf(perlengkapanbayi),
    		   "pampers: "+String.valueOf(pampers),"pakaian balita: "+String.valueOf(pakaianbalita),"mpasi: "+String.valueOf(mpasi),
    		   "sarung: "+String.valueOf(sarung),"pakaian: "+String.valueOf(pakaian),"tongkat: "+String.valueOf(tongkat),
    		   "biskuit: "+String.valueOf(biskuit),"suplemen: "+String.valueOf(suplemen),"beras: "+String.valueOf(beras),
    		   "ikan asin: "+String.valueOf(ikanasin),"kecap: "+String.valueOf(kecap),"sambal: "+String.valueOf(sambal),
    		   "mie: "+String.valueOf(mie),"selimut: "+String.valueOf(selimut),"kaos dewasa: "+String.valueOf(kaosdewasa),
    		   "kaos anak: "+String.valueOf(kaosanak),"seragam sd laki-laki: "+String.valueOf(seragamsdlk),
    		   "seragam sd perempuan: "+String.valueOf(seragamsdp),"tandu: "+String.valueOf(tandu),"tenda: "+String.valueOf(tenda)};
		TextViewKebutuhan.setText("Jumlah Korban :"+String.valueOf(count));
		ArrayAdapter<String> adapterKebutuhan = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1
				,values);
		listKebutuhan.setAdapter(adapterKebutuhan);
		 
		
		mbutton= (Button)findViewById(R.id.button1);
		medit1=(EditText)findViewById(R.id.editTextBujur);
		medit2=(EditText)findViewById(R.id.editTextLintang);
		alert = new AlertDialog.Builder(getApplicationContext());
		 mbutton.setOnClickListener(
			        new View.OnClickListener()
			        {
			            public void onClick(View view)
			            {
			                Log.v("EditText", medit1.getText().toString());
			                Log.v("EditText", medit2.getText().toString());
			                if(!medit1.getText().toString().isEmpty()){
			                bujur=Integer.parseInt(medit1.getText().toString());}
			                if(!medit2.getText().toString().isEmpty()){
			                lintang=Integer.parseInt(medit2.getText().toString());}
			                
			                poskoinput=new GeoPoint(lintang*((int)Math.pow(10,6)),bujur*(int)Math.pow(10,6));
			                Log.v("bujur",String.valueOf(poskoinput.getLongitudeE6()));
			                Log.v("lintang ",String.valueOf(poskoinput.getLatitudeE6()));
			                Log.v("bujurA ",String.valueOf(poskoA.getLongitudeE6()));
			                Log.v("lintang/1e6 ",String.valueOf((double)poskoinput.getLatitudeE6()/1e6));
			                
			                //alert.setTitle("tes").setMessage(medit1.getText().toString()).show();
			                Location.distanceBetween((double)poskoinput.getLatitudeE6()/1e6, (double)poskoinput.getLongitudeE6()/1e6, (double)poskoA.getLatitudeE6()/1e6, (double)poskoA.getLongitudeE6()/1e6, resultsA);
			                Log.v("jarak ke A",String.valueOf(resultsA[0]));
			                /*if (resultsA[0]<=1){
			                	alert.setTitle("tes").setMessage("posko A").show();
			                }else{
			                Location.distanceBetween(poskoinput.getLatitudeE6(), poskoinput.getLongitudeE6(), poskoB.getLatitudeE6(), poskoB.getLongitudeE6(), resultsB);
			                if (resultsB[0]<=1){
			                	alert.setTitle("tes").setMessage("posko B").show();
			                }else
			                	alert.setTitle("tes").setMessage("bukan di posko").show();
			                }*/
			            }
			        });
	        flipper.setOnTouchListener(new View.OnTouchListener() {

	        	@Override
	        	public boolean onTouch(View v, MotionEvent event) { 
	        		
	        	if (v!=flipper) return false;
	        	if (event.getAction()==MotionEvent.ACTION_UP){
	        		xUp=event.getX();
	        	} else if(event.getAction()==MotionEvent.ACTION_DOWN){
	        		xDown=event.getX();
	        		if (xUp<xDown){
	        			flipper.setAnimation(slideLeftIn);
	        			flipper.setAnimation(slideLeftOut);
	        			flipper.showNext();
	        		}else if(xUp>xDown){
	        			flipper.setAnimation(slideRightIn);
	        			flipper.setAnimation(slideRightOut);
	        			flipper.showPrevious();
	        		}
	        	}
	        		
	        	return true;
	        	
	            
	        	}
	        	});
    }
	
	
	 class ScrollRight implements AnimationListener{

     	@Override
     	public void onAnimationEnd(Animation animation) {
     	
     	}

     	@Override
     	public void onAnimationRepeat(Animation animation) {
     	// TODO Auto-generated method stub

     	}

     	@Override
     	public void onAnimationStart(Animation animation) {
     	// TODO Auto-generated method stub

     	}
     	

     	}
	 class ScrollLeft implements AnimationListener{

  		@Override
  		public void onAnimationEnd(Animation animation) {
  		
  		}

  		@Override
  		public void onAnimationRepeat(Animation animation) {
  		// TODO Auto-generated method stub

  		}

  		@Override
  		public void onAnimationStart(Animation animation) {
  		// TODO Auto-generated method stub

  		}

  		}

	public static ArrayList<nm> searchFolder(String searchPath, ArrayList<nm> nmList){
	    File dir = new File(searchPath);
	   
	    for(File item : dir.listFiles()){
	        if(item.isDirectory()){
	            //recursively search subdirectories
	        	//System.out.println("Dir :"+item.getAbsolutePath());
	            searchFolder(item.getAbsolutePath(),nmList);          
	        } else if(item.isFile()){
	        	//System.out.println("File :"+item.getAbsolutePath());
	        	ArrayList<nm> tambah = null;
	        	tambah=processFile(item);
	        	
	        	nmList.addAll(tambah);  
	          
	        }
	        	
	    }
	    //if(nmList.isEmpty()){
        //	System.out.println("nmList di searchfolder=null");	
       // }   
   return nmList;
	}

	public static ArrayList<nm> processFile(File aFile){
	    //String filename = aFile.getAbsolutePath();
	    //String txtFilename = filename.substring(0, filename.lastIndexOf(".")) + ".txt";
	    //Do your xml file parsing and write to txtFilename
	     ArrayList<nm> nmList = new ArrayList<nm>();
	    try {
	    	SAXParser parser;
	    	
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			parser = parserFactor.newSAXParser();
	    SAXHandler handler = new SAXHandler();
	    
	    
 
      try {
			parser.parse(aFile, handler);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    nmList=handler.getnmList();
	    
      
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if (nmList.isEmpty()){
    		System.out.println("nmList kosong");
    	} 
	    
	    	 
	    
	    return nmList;
	    
	}  
	
		  }     


		  
 final class SAXParserDemo {

	  public static ArrayList<nm> getNmList() {
		ArrayList<nm> nmList=new ArrayList<nm>();
	    
		String ODK_ROOT = Environment.getExternalStorageDirectory()
                + File.separator + "odk";
        String path = ODK_ROOT + File.separator + "instances";
	    
		KebutuhanActivity.searchFolder(path,nmList);

	    //Printing the list of employees obtained from XML
	   // for ( nm nmvar : handler.nmList){
	   //   System.out.println(nmvar);
	      
	   // }
		//if(nmList==null){
		//    System.out.println("Di SAXParserDemo nmList=null");	
		//    }
      return nmList;
	  }
	  
	}

 
	/**
	 * The Handler for SAX Events.
	 */
	
 class SAXHandler extends DefaultHandler {

	  ArrayList<nm> nmList = new ArrayList<nm>();
	  nm nmvar = null;
	  String content = null;
	  //SAXHandler parentHandler;
	 
	  private ArrayList<repeat_observation> alrepeat;
	  private repeat_observation repeatO;
	 
	       
	    

	  @Override
	  //Triggered when the start of tag is found.
	  public void startElement(String uri, String localName, 
	                           String qName, Attributes attributes) 
	                           throws SAXException {

	    if(qName.equalsIgnoreCase("nm")){
	      //Create a new Employee object when the start tag is found
	     
	        nmvar = new nm();
	        nmvar.id = attributes.getValue("id");	 
	        alrepeat = new ArrayList<repeat_observation>();
	    }
	    else if (qName.equalsIgnoreCase("repeat_observation")){
	    	repeatO = new repeat_observation();
	    }
	  }

	  @Override
	  public void endElement(String uri, String localName, 
	                         String qName) throws SAXException {
	  
		  if(qName.equalsIgnoreCase("nm")){
	     //Add the employee to list once end tag is found
			  nmvar.setAlRepeat(alrepeat);
			  nmList.add(nmvar);
			  alrepeat = null;
	   }
	     //For all other end tags the employee has to be updated.
		  else if(qName.equalsIgnoreCase("jenis")){
	     
	       nmvar.jenis = content;
	   }
		  else if(qName.equalsIgnoreCase("tanggal")){
		     
		   nmvar.tanggal = content;
	   }
		  else if(qName.equalsIgnoreCase("lokasi")){
		     
		   nmvar.lokasi = content;
	   }
		  else if ("repeat_observation".equals(qName)) {
		  if (alrepeat!=null){
		   alrepeat.add(repeatO);
		   repeatO = null;
		  }
	   }
		  else if (qName.equalsIgnoreCase("kecamatan")){
			  repeatO.kecamatan = content;
		  }
		  else if (qName.equalsIgnoreCase("kelurahandesa")){
			  repeatO.kelurahandesa = content;
		  }
		  else if (qName.equalsIgnoreCase("namakorban")){
			  repeatO.namakorban = content;
		  }
		  else if (qName.equalsIgnoreCase("kondisikorban")){
			  repeatO.kondisikorban = content;
		  }
	  }

	  @Override
	  public void characters(char[] ch, int start, int length) 
	          throws SAXException {
	    content = String.copyValueOf(ch, start, length).trim();
	  }
	  public ArrayList<nm> getnmList(){
		  return nmList;
		  }
	}

	
 class nm {
	
	   String id;
	   String jenis;
	   String tanggal;
	   String lokasi;
	   String keterangan;
	   public String getJenis(){
			return jenis;  
		  }
	   public String getTanggal(){
			return tanggal;  
		  }
	   public String getLokasi(){
			return lokasi;  
		  }
	   public String getKeterangan(){
			return keterangan;  
		  }
	  private ArrayList<repeat_observation> alrepeat;
	  public ArrayList<repeat_observation> getAlRepeat() {
	        return alrepeat;
	    }
	  public  void setAlRepeat(ArrayList<repeat_observation> alrepeat) {
	        this.alrepeat = alrepeat;
	    }
	  
		  
	  }
	  class repeat_observation{
		  String kecamatan;
		  String kelurahandesa;
		  String namakorban;
		  String kondisikorban;
		  public String getKecamatan(){
			return kecamatan;  
		  }
		  public String getKelurahanDesa(){
				return kelurahandesa;  
			  }
		  public String getNamaKorban(){
				return namakorban;  
			  }
		  public String getKondisiKorban(){
				return kondisikorban;  
			  }
		  }
	 
	  
	  
	
	