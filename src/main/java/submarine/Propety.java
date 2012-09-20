package submarine;

import cn.ohyeah.itvgame.model.OwnProp;
import cn.ohyeah.stb.game.EngineService;
import cn.ohyeah.stb.game.ServiceWrapper;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.PopupText;

public class Propety implements Common{
	
	protected  int slowPropNum;    	//���ٵ�������
	protected  int laserPropNum;	//�����������
	protected  int medigelPropNum;	//��Ѫ��������
	protected  int airDropPropNum;	//��Ͷ��������
	protected  int limitBooldPropNum;//��Ѫ���޵�������		
	protected  int energyPropNum;	//����������������
	protected  int hidePropNum;		//�����������
	protected  int dartlePropNum;	//�����������	
	
	public static int useHidePropNum;	//ʹ�������������
	public static int useLimitBooldPropNum;//ʹ�ü�������������
	public static int useMedigelPropNum;   //ʹ�û�Ѫ��������
	
	public static int[] propIds = {34,35,36,37,38,39,40,41};
	public static int[] propPrice = {3,4,5,3,6,2,3,4};
	
	private SubmarineGameEngine engine;
	
	public Propety(SubmarineGameEngine engine) {
		this.engine = engine;
	}
	
	/*��ѯ�û����еĵ���(Ҫ�����Ǳͧ����)*/
 	public void queryOwnAllProps(){
		//OwnProp[] props = new OwnProp[8];
		ServiceWrapper sw = engine.getServiceWrapper();
		OwnProp[] props = sw.queryOwnPropList();
		if(props==null){
			return;
		}
		/*for(int i=0;i<props.length;i++){
			//props[ownProps[i].getPropId()-34] =  
			
			if(queryOwnProp(engineService, i+34)==null){
				OwnProp ownProp = new OwnProp();
				ownProp.setCount(0);
				ownProp.setPropId(i+34);
				props[i] = ownProp;
			}else{
				props[i] = queryOwnProp(engineService, i+34);
			}
		}*/
		for(int i=0;i<props.length;i++){
			if(props[i].getPropId()==37){
				airDropPropNum = props[i].getCount();
			}else if(props[i].getPropId()==41){
				dartlePropNum = props[i].getCount();
			}else if(props[i].getPropId()==34){
				slowPropNum = props[i].getCount();
			}else if(props[i].getPropId()==40){
				hidePropNum = props[i].getCount();
			}else if(props[i].getPropId()==35){
				laserPropNum = props[i].getCount();
			}else if(props[i].getPropId()==39){
				energyPropNum = props[i].getCount();
			}else if(props[i].getPropId()==38){
				limitBooldPropNum = props[i].getCount();
			}else if(props[i].getPropId()==36){
				medigelPropNum = props[i].getCount();
			}
			else if (props[i].getPropId()==42) {
				SubmarineGameEngine.isPurchase = true;
			}
			else if (props[i].getPropId()==43) {
				SubmarineGameEngine.isPurchase2 = true;
			}
		}
		System.out.println("airDropPropNum:"+airDropPropNum);
		System.out.println("dartlePropNum:"+dartlePropNum);
		System.out.println("slowPropNum:"+slowPropNum);
		System.out.println("hidePropNum:"+hidePropNum);
		System.out.println("laserPropNum:"+laserPropNum);
		System.out.println("energyPropNum:"+energyPropNum);
		System.out.println("limitBooldPropNum:"+limitBooldPropNum);
		System.out.println("medigelPropNum:"+medigelPropNum);
		System.out.println("isPurchase:"+SubmarineGameEngine.isPurchase);
		System.out.println("isPurchase2:"+SubmarineGameEngine.isPurchase2);
		//return props;
	}
	
	/*������ID��ѯ*/
	//public OwnProp[] queryOwnProp(EngineService engineService){
	/*	ServiceWrapper sw = engine.getServiceWrapper();
		return sw.queryOwnPropList();*/
		/*
		OwnProp ownProp = null;
		if(sw.isServiceSuccessful() && props!=null){
			for(int i=0;i<props.length;i++){
				if(propId == props[i].getPropId()){
					ownProp = props[i];
					System.out.println("propId:"+ownProp.getPropId());
					System.out.println("propCount:"+ownProp.getCount());
				}
			}
		}*/
		//return ownProp;
	//}
	
	private boolean buyProp(int propId, int propCount, int price, String propName) {
		//if (engine.getEngineService().getBalance() >= price) {
			ServiceWrapper sw = engine.getServiceWrapper();
			//sw.purchaseProp(propId, propCount, "����"+propName);
			sw.expend(price, propId, "����"+propName);
			PopupText pt = UIResource.getInstance().buildDefaultPopupText();
			if (sw.isServiceSuccessful()) {
				pt.setText("����"+propName+"�ɹ�");
			}
			else {
				pt.setText("����"+propName+"ʧ��, ԭ��: "+sw.getServiceMessage());
				
			}
			pt.popup();
			return sw.isServiceSuccessful();
		//}
		/*else {
			PopupConfirm pc = UIResource.getInstance().buildDefaultPopupConfirm();
			pc.setText("��Ϸ�Ҳ���,�Ƿ��ֵ");
			if (pc.popup() == 0) {
				StateRecharge recharge = new StateRecharge(engine);
				recharge.recharge();
			}
			return false;
		}*/
	}
	
	/*�������*/
	public void purchaseProp(Role own, int shopX, int shopY,EngineService engineService){
		if(shopX==0 && shopY==0){
			int propId = 39;
			if (buyProp(propId, 1, propPrice[5], "����������")) {
				energyPropNum++;
			}
		}
		if(shopX==1 && shopY==0){
			int propId = 40;
			if (buyProp(propId, 1, propPrice[6], "����װ��")) {
				hidePropNum++;
			}
		}
		if(shopX==0 && shopY==1){
			int propId = 34;
			if (buyProp(propId, 1, propPrice[0], "���̵���")) {
				slowPropNum++;
			}
		}
		if(shopX==1 && shopY==1){
			int propId = 37;
			if (buyProp(propId, 1, propPrice[3], "���п�Ͷ")) {
				airDropPropNum++;
			}
		}
		if(shopX==0 && shopY==2){
			int propId = 41;
			if(buyProp(propId, 1, propPrice[7], "����")) {
				dartlePropNum++;
			}
		}
		if(shopX==1 && shopY==2){
			int propId = 35;
			if (buyProp(propId, 1, propPrice[1], "��͸���ⵯ")) {
				laserPropNum++;
			}
		}
		if(shopX==0 && shopY==3){
			int propId = 36;
			if (buyProp(propId, 1, propPrice[2], "ά�޻�����")) {
				medigelPropNum++;
			}
		}
		if(shopX==1 && shopY==3){
			int propId = 38;
			if (buyProp(propId, 1, propPrice[4], "����װ��")) {
				limitBooldPropNum++;
			}
		}
		if(shopX==101){
			int propId = 42;
			boolean result = buyProp(propId, 1, 200, "���к�");
			if(result){
				SubmarineGameEngine.isPurchase = true;
			}
		}
		if(shopX==102){
			int propId = 43;
			boolean result = buyProp(propId, 1, 200, "ɣ���");
			if(result){
				SubmarineGameEngine.isPurchase2 = true;
			}
		}
	}
}
