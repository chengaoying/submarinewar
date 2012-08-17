package submarine;

import java.io.IOException;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import cn.ohyeah.itvgame.model.GameRanking;
/*import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;*/
import cn.ohyeah.stb.ui.DrawUtil;
import cn.ohyeah.stb.ui.TextView;
import cn.ohyeah.stb.util.RandomValue;

/**
 * ����Ϸ����
 * @author xiaochen
 *
 */
public class DrawGame implements Common{
	
	private SubmarineGameEngine engine;
	
	public DrawGame(SubmarineGameEngine engine) {
		this.engine = engine;
	}	

	private Image imgMain1, imgMain2, imgMapUp, imgMapCenter, imgMapDown, imgMapRight, imgKa, imgInfo, imgConfirm, imgDirection,imgMain3, imgSubmirine;
	private Image imgLevel, imgMain4, imgBiglevel, imgPrompt, imgRanking, imgShop;
	private Image imgBlood, imgBlood2, imgMenu, imgNumber2, imgGk, imgGameInfo, imgPass, imgOver,imgMedal,imgWarning;
	private Image imgCallBoard, imgLock, imgPurchaseIcon, imgBoat, imgIceBerg, imgIceBerg2, imgPrompt2;
	private Image imgRecharge, imgRechargeSuccess, imgRechargeFail, imgPurchaseSuccess, imgPurchaseFail, imgPassSelect;
	private Image imgDifficultLevel2, imgHelp, imgHelp2, imgRules,imgLifeNums, imgSubmarineName, imgPassBg, imgPassText, imgPassFireWork,imgDifficultLock;
	private int menuW = 218, menuH = 43, W=218, H=43;
	private int promptIndex=0, promptFlag=4;
	private boolean isPrompt = false, isFire2,isFire3,isFire4;
	public static boolean isFireOver;
	private int mapFlag, mapIndex, mapFlag2, mapIndex2, boatIndex,boatFlag, iceFlag, iceIndex, iceFlag2,iceIndex2;
	private int ran, ran2, flag, index, warnFlag, warnIndex, textFlag, textIndex, fireFlag, fireIndex,fireFlag2, fireIndex2,fireFlag3, fireIndex3,fireFlag4, fireIndex4;
	private int mapx1,mapy1, mapx2,mapy2,mapx3,mapy3,mapx4,mapy4, fireCount;
	private int[][] coordinate ={
			{20,150,250,300},
			{300,200,150,30},
	};
	
	private int para[][] = {
			{220, 140},
			{375, 143},
			{480, 236},
			{265, 295},
			{337, 207},
	};
	private String str[][]={
			{"Ѫ��","60", "����ǿ��","100", "������ʽ","����",  "�ƶ��ٶ�","100��",},
			{"Ѫ��","100", "����ǿ��","150", "������ʽ","������", "�ƶ��ٶ�","200��",},
			{"Ѫ��","60", "����ǿ��","200", "������ʽ","���� ", "�ƶ��ٶ� ","300��",},
			
			/*������Ϣ*/
			{"���;�������ս��", "ӵ��ǿ�����ս����", "�ó�����ˮ��Ǳͧ��","��̽��"},
			{"���;�������ս��", "�籩�ŵĸ�����", "�籩�ŵĻ����ϼ�ǿ", "�˹�����Χ�ͷ�����"},
			{"���;�������ս��", "�籩�ŵĸ�����", "�籩�ŵĻ����ϼ�ǿ", "�˹��������ƶ���"},
	};
	
	private String desc[][] = {
			{"����һ�ι����˺�", "����״̬������15�룬��������ʹ��5��"},
			{"����ȫ��Ǳͧ���ƶ��ٶ�66%������ʱ��15��", "���пվ�֧Ԯ,�ӿ���Ͷ��5ö���������Թ���������λ,�����ˮ��"},
			{"����2��ը����������Ч,���غ�״̬��ʧ", "�����ͷų�ͬ����ͬ��ļ���ᴩ���³���5�룬���Թ���������λ"},
			{"�ָ�����Ѫ״̬������ֻ��ʹ��3��", "����һ�������������������Ϊ5��,��������ʹ��2��"},
	};
	
	private String gameIntro[] = {
			"<̫ƽ��ս>��һ��2D���������Ϸ.",
			"��Ҳٿع��;����𽢻������������,̽��",
			"̫ƽ���. ",
			"��Ϸ���м�.�е�.�Ѷ�.3���Ѷȼ���. ",
			"�̳����а˸�������ʵ�õĵ��߹���������������Ի�",
			"�Ե�����ɻ����ԵĹ���.",
			"����ں���ʹ�õ����Լ�Ϭ���Ĳ�������5��BOSS",
			"�������.",
	};
	
	/*private int nums[][] = {
			{20,0,0,0,0},
			{10,5,5,0,0},
			{5,5,5,5,0},
			{0,5,5,5,10},
			{0,5,10,10,15}
	};*/
	public static int totalnums[] = {20,30,35,40,40};
	public static String msg = ""; 
	public static long msgTime,msgTime2;
	/*���˵�*/
	public void drawMainMenu(Graphics g, int index, int favorIndex){
		if (imgMain1 == null || imgMain2 == null) {
			try {
				imgMain1 = Image.createImage("/main1.jpg");
				imgMain2 = Image.createImage("/main2.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		g.setClip(Abs_Coords_X, Abs_Coords_Y, screenW, screenH);
		g.setColor(0X000000);
		g.fillRect(Abs_Coords_X, Abs_Coords_Y, screenW, screenH);
		g.drawImage(imgMain1, Abs_Coords_X, Abs_Coords_Y, TopLeft);
		int menuAxis[][] = { { 200, 223 }, { 200, 270  }, { 200, 317  },
				{ 200, 364  }, { 200, 411  },{ 200, 458  } };
		for (int i = 0; i < menuAxis.length; ++i) {
			g.drawRegion(imgMain2, (index != i) ? 0 : menuW, i * menuH,
					menuW, menuH, 0, menuAxis[i][0]+Abs_Coords_X, menuAxis[i][1]+Abs_Coords_Y, 0);
			
		}
		
		/*if(SubmarineGameEngine.isSupportFavor){
			if(imgFavor == null){
				try {
					imgFavor = Image.createImage("/favorite.png");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			g.drawImage(imgFavor, 538, 429, TopLeft);
			if(favorIndex==1){
				DrawUtil.drawRect(g, 538, 429, 83, 86, 2, 0XFFFF00);
			}
		}*/
	}
	
	/*��Ϸ��*/
	public void drawGamePlaying(Graphics g,int r){
		drawMap(g,r);
	}

	/*��Ϸ�еĲ˵�*/
	public void drawPalyingMenu(Graphics g, int index){
		if (imgMenu == null) {
			try {
				imgMenu = Image.createImage("/menu.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		g.drawRegion(imgMenu, 0, 0, 202, 192, 0, 150+Abs_Coords_X, 165+Abs_Coords_Y, TopLeft);
		//g.drawRegion(imgSelect2, 0, 0, 160, 55, 0, 172, 176+index*56, TopLeft);
		DrawUtil.drawRect(g, 172+Abs_Coords_X, 175+index*58+Abs_Coords_Y, 158, 53, 2, 0XFFFF00);
	}

	/*û����Ϸ��¼ʱ��ʾ*/
	private int FontH = 15;
	public void drawNoRecord(Graphics g){
		Font curFont = Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
		g.setFont(curFont);
		int tw = curFont.stringWidth("û����Ϸ��¼") + 30;
		int th = FontH + 20;
		int tx = 258;//screenW / 2 - tw / 2;
		int ty = screenH / 2 - th;
		g.setClip(0+Abs_Coords_X, 0+Abs_Coords_Y, screenW, screenH);
		g.setColor(26, 131, 238); 
		g.fillRect(tx+Abs_Coords_X, ty+Abs_Coords_Y, tw, th);// ����
		g.setColor(243, 191, 99); //�����ɫ
		g.drawRect(tx - 1+Abs_Coords_X, ty - 1+Abs_Coords_Y, tw + 1, th + 1);// ����
		g.drawRect(tx - 2+Abs_Coords_X, ty - 2+Abs_Coords_Y, tw + 3, th + 3);// ����
		g.setColor(0xffffff);
		g.drawString("û����Ϸ��¼", tx + 15+Abs_Coords_X, ty + 8+Abs_Coords_Y, TopLeft);
	}
	
/*	private String getKeyCodeStr(int keyCode) {
		if (keyCode == KeyCode.LEFT) {
			return "left";
		}
		else if (keyCode == KeyCode.RIGHT) {
			return "right";
		}
		else if (keyCode == KeyCode.OK) {
			return "ok";
		}
		else {
			return "other";
		}
	}*/
	/*��Ϸ��ͼ*/
	int x1=150, x2=433, x3=403;
	private void drawMap(Graphics g, int r) {
		/*KeyState keyState = engine.getKeyState();
		engine.addDebugUserMessage(getKeyCodeStr(keyState.getCurrentKeyCode())+" M:"+keyState.hasPersistMoveEvent()
				+" LM:"+keyState.containsMoveEvent(KeyCode.LEFT)+" RM:"+keyState.containsMoveEvent(KeyCode.RIGHT));*/
		
		if (imgMapUp==null || imgMapCenter==null || imgMapDown==null || imgMapRight==null
				|| imgBoat==null || imgIceBerg==null || imgIceBerg2==null || imgWarning==null) {
			try {
				imgMapRight = Image.createImage("/mapRight.png");
				imgMapDown = Image.createImage("/mapDown.png");
				imgBoat = Image.createImage("/boat.png");
				imgWarning = Image.createImage("/warning.png");
				if(r==0){
					imgIceBerg = Image.createImage("/iceberg.png");
					imgIceBerg2 = Image.createImage("/iceberg2.png");
					imgMapUp = Image.createImage("/mapUp.jpg");
					imgMapCenter = Image.createImage("/mapCenter.jpg");
				}else{
					imgIceBerg = Image.createImage("/ice.png");
					imgIceBerg2 = Image.createImage("/ice2.png");
					imgMapUp = Image.createImage("/mapUp2.jpg");
					imgMapCenter = Image.createImage("/mapCenter2.jpg");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try{
			if(mapFlag<3){
				mapFlag++;
			}else{
				mapIndex=(mapIndex+1)%640;
				mapFlag=0;
			}
			if(mapFlag2==1){
				mapFlag2++;
			}else{
				mapIndex2=(mapIndex2+1)%640;
				mapFlag2=0;
			}
			if(boatFlag==1){
				boatFlag++;
			}else{
				boatIndex=(boatIndex+1)%640;
				boatFlag=0;
			}
			if(iceFlag<2){
				iceFlag++;
			}else{
				iceIndex=(iceIndex+1)%640;
				iceFlag=0;
			}
			if(iceFlag2<2){
				iceFlag2++;
			}else{
				iceIndex2=(iceIndex2+1)%700;
				iceFlag2=0;
			}
			if(mapIndex<=160){
				g.drawRegion(imgMapUp, mapIndex, 0, 480, 120, 0, Abs_Coords_X, Abs_Coords_Y, TopLeft);
			}else{
				g.drawRegion(imgMapUp, mapIndex, 0, 640-mapIndex, 120, 0, Abs_Coords_X, Abs_Coords_Y, TopLeft);
				g.drawRegion(imgMapUp, 0, 0, 480-(640-mapIndex), 120, 0, 640-mapIndex+Abs_Coords_X, Abs_Coords_Y, TopLeft);
			}
			if(mapIndex2<=160){
				g.drawRegion(imgMapCenter, mapIndex2, 0, 480, 430, 0, Abs_Coords_X, 100+Abs_Coords_Y, TopLeft);
			}else{
				g.drawRegion(imgMapCenter, mapIndex2, 0, 640-mapIndex2, 430, 0, Abs_Coords_X, 100+Abs_Coords_Y, TopLeft);
				g.drawRegion(imgMapCenter, 0, 0, 480-(640-mapIndex2), 430, 0, 640-mapIndex2+Abs_Coords_X, 100+Abs_Coords_Y, TopLeft);
			}
			if((x1-iceIndex+221)<=0+Abs_Coords_X){
				iceIndex=0;
				x1=479;
				ran = RandomValue.getRandInt(2);
			}
			if((x3-iceIndex2+273)<=0+Abs_Coords_X){
				iceIndex2=0;
				x3=479;
				ran2 = RandomValue.getRandInt(2);
			}
			if((x2-boatIndex+94)<=0+Abs_Coords_X){
				boatIndex=0;
				x2=479;
			}
			if(ran==0){
				g.drawRegion(imgIceBerg, 0, 0, imgIceBerg.getWidth(), imgIceBerg.getHeight(), 0, x1-iceIndex+Abs_Coords_X, 74+Abs_Coords_Y, TopLeft);
			}
			if(ran2==0){
				g.drawRegion(imgIceBerg2, 0, 0, imgIceBerg2.getWidth(), imgIceBerg2.getHeight(), 0, x3-iceIndex2+Abs_Coords_X, 70+Abs_Coords_Y, TopLeft);
			}
			g.drawRegion(imgBoat, 0, 0, imgBoat.getWidth(), imgBoat.getHeight(), 0, x2-boatIndex+Abs_Coords_X, 390+Abs_Coords_Y, TopLeft);
			
			g.drawImage(imgMapDown, 0+Abs_Coords_X, 485+Abs_Coords_Y, TopLeft);
			g.drawImage(imgMapRight, 481+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
			
			/*BOSS����ǰ�ľ���*/
			if((SubmarineGameEngine.warnEndTime-SubmarineGameEngine.warnStartTime)<3/* && !SubmarineGameEngine.isBoss5War*/){
				if(warnFlag<2){
					warnFlag++;
				}else{
					warnIndex=(warnIndex+1)%2;
					warnFlag=0;
				}
				g.setColor(0);
				g.fillRect(0+Abs_Coords_X, 125+Abs_Coords_Y, 480, 60);
				//g.drawRegion(imgWarning, imgWarning.getWidth()/3*warnIndex, 0, imgWarning.getWidth()/3, imgWarning.getHeight(), 0, 150, 130, TopLeft);
				if(warnFlag==1){
					g.drawImage(imgWarning, 200+Abs_Coords_X, 130+Abs_Coords_Y, TopLeft);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*�Ѷ�ѡ�����*/
	public void drawDiffucltyLevel(Graphics g, int index){
		if(imgDifficultLevel2==null||imgMain1==null||imgDifficultLock==null){
			try {
				imgDifficultLevel2 = Image.createImage("/difficultylevel2.png");
				imgMain1 = Image.createImage("/main1.jpg");
				imgDifficultLock = Image.createImage("/difficultLock.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		g.drawImage(imgMain1, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		int menu[][] = { { 200, 223 }, { 200, 270 }, 
				{ 200, 317 }};
		for (int i = 0; i < menu.length; ++i) {
			g.drawRegion(imgDifficultLevel2, (index != i) ? 0 : W, i * H,
					W, H, 0, menu[i][0]+Abs_Coords_X, menu[i][1]+Abs_Coords_Y, 0);
			
		}
		if(!SubmarineGameEngine.isOpenDifficult2){
			g.drawImage(imgDifficultLock, 302+Abs_Coords_X, 278+Abs_Coords_Y, TopLeft);
		}
		if(!SubmarineGameEngine.isOpenDifficult3){
			g.drawImage(imgDifficultLock, 302+Abs_Coords_X, 326+Abs_Coords_Y, TopLeft);
		}
	}
	
	/*��ͧѡ�����*/
	public void drawSelectSubmarine(Graphics g, int selectL, int selectR, int index, int index2, boolean down, int confirm, int id, boolean isPurchase, boolean isPurchase2){
		if (imgInfo==null || imgConfirm==null || imgDirection==null
				|| imgMain3==null || imgSubmirine==null || imgLock==null 
				|| imgPurchaseIcon==null || imgSubmarineName==null) {
			try {
				imgInfo = Image.createImage("/info.png");
				imgConfirm = Image.createImage("/confirm.png");
				imgDirection = Image.createImage("/direction.png");
				imgMain3 = Image.createImage("/main3.jpg");
				imgSubmirine = Image.createImage("/submirine.png");
				imgLock = Image.createImage("/lock.png");
				imgPurchaseIcon = Image.createImage("/purchaseIcon.png");
				imgSubmarineName = Image.createImage("/submarineName.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		g.drawImage(imgMain3, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		
		g.drawRegion(imgInfo, 0, 0, imgInfo.getWidth(), imgInfo.getHeight(), 0, 20+Abs_Coords_X, 90+Abs_Coords_Y, TopLeft);
		
		g.drawRegion(imgDirection, selectL*31, 0, 31, 56, 0, 260+Abs_Coords_X, 262+Abs_Coords_Y, TopLeft);
		g.drawRegion(imgSubmirine, index*284, 0, 284, 104,0, 296+Abs_Coords_X, 226+Abs_Coords_Y, TopLeft);
		g.drawRegion(imgSubmarineName, index*246, 0, 246, 77, 0, 320+Abs_Coords_X, 120+Abs_Coords_Y, TopLeft);
		g.drawRegion(imgDirection, selectR*31, 56, 31, 56, 0, 585+Abs_Coords_X, 262+Abs_Coords_Y, TopLeft);
		
		if(down){
			if(confirm==0){
				DrawUtil.drawRect(g, 288+Abs_Coords_X, 379+Abs_Coords_Y, 134, 53, 2, 0XFFFF00);
			}else{
				DrawUtil.drawRect(g, 457+Abs_Coords_X, 379+Abs_Coords_Y, 134, 53, 2, 0XFFFF00);
			}
		}else{
			if(index2==0){
				DrawUtil.drawRect(g, 260+Abs_Coords_X, 263+Abs_Coords_Y, 33, 53, 2, 0XFFFF00);
			}else{
				DrawUtil.drawRect(g, 583+Abs_Coords_X, 263+Abs_Coords_Y, 33, 53, 2, 0XFFFF00);
			}
		}
		g.drawRegion(imgConfirm, 0, imgConfirm.getHeight()/2, imgConfirm.getWidth(), imgConfirm.getHeight()/2, 
						0, 459+Abs_Coords_X, 381+Abs_Coords_Y, TopLeft);
		
		if((!isPurchase && id == 101) || (!isPurchase2 && id == 102)){
			g.drawImage(imgLock, 350+Abs_Coords_X, 260+Abs_Coords_Y, TopLeft);
			g.drawImage(imgPurchaseIcon, 290+Abs_Coords_X, 381+Abs_Coords_Y, TopLeft);
			/*Ǳͧ�۸�*/
			if(index==1){
				drawNum(g, 200, 465+Abs_Coords_X, 299+Abs_Coords_Y);
			}else if(index==2){
				drawNum(g, 200, 465+Abs_Coords_X, 299+Abs_Coords_Y);
			}
			
		}else{
			g.drawRegion(imgConfirm, 0, 0, imgConfirm.getWidth(), imgConfirm.getHeight()/2, 
					0, 290+Abs_Coords_X, 381+Abs_Coords_Y, TopLeft);
		}
	
		/*��ͧ��Ϣ*/
		g.setColor(28, 213, 233);
		engine.setFont(19);
		g.drawString(str[id-100][0], 42+Abs_Coords_X, 123+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100][1], 140+Abs_Coords_X, 123+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100][2], 42+Abs_Coords_X, 153+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100][3], 140+Abs_Coords_X, 153+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100][4], 42+Abs_Coords_X, 183+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100][5], 140+Abs_Coords_X, 183+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100][6], 42+Abs_Coords_X, 213+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100][7], 140+Abs_Coords_X, 213+Abs_Coords_Y, TopLeft);
		/*������Ϣ*/
		g.drawString(str[id-100+3][0], 42+Abs_Coords_X, 287+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100+3][1], 42+Abs_Coords_X, 317+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100+3][2], 42+Abs_Coords_X, 347+Abs_Coords_Y, TopLeft);
		g.drawString(str[id-100+3][3], 42+Abs_Coords_X, 377+Abs_Coords_Y, TopLeft);
		engine.setDefaultFont();
	}
	
	/*��ըЧ��һ*/
	public void drawBurstEffect(Graphics g, int mapx, int mapy, int frame){
		g.setClip(0+Abs_Coords_X, 0+Abs_Coords_Y, gameMapX, gameMapY);
		if (imgKa == null) {
			try {
				imgKa = Image.createImage("/ka.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if((mapx+68)<480 && frame<13){
			g.drawRegion(imgKa, frame*(imgKa.getWidth()/14), 0, imgKa.getWidth()/14, imgKa.getHeight(), 0, mapx, mapy, TopLeft);
		}
		g.setClip(0+Abs_Coords_X, 0+Abs_Coords_Y, screenW, screenH);
	}
	
	/*��ըЧ����*/
	public void drawBurstEffect2(Graphics g, int mapx, int mapy){
		g.setClip(0+Abs_Coords_X, 0+Abs_Coords_Y, gameMapX, gameMapY);
		if (imgKa == null) {
			try {
				imgKa = Image.createImage("/ka.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if((mapx+68)<480 ){
			g.drawRegion(imgKa, index*(imgKa.getWidth()/14), 0, imgKa.getWidth()/14, imgKa.getHeight(), 0, mapx, mapy, TopLeft);
			if(flag==0){
				flag++;
			}else{
				index=(index+1)%2;
				flag=0;
			}
			if(index==1){
				SubmarineGameEngine.bombFlag=false;
			}
		}
		g.setClip(0+Abs_Coords_X, 0+Abs_Coords_Y, screenW, screenH);
	}
	
	/*����ͧ��Ϣ*/
	public void drawInfo(Graphics g, Role own, int limitLife, int level, Propety propety){
		/*Ѫ��*/
		//int currBoold = (own.nonceLife*90)/CreateRole.ownPara[own.id-100][2];
		int currBoold = own.nonceLife*90/limitLife;
		if(imgBlood==null || imgBlood2 ==null || imgGk == null || imgMedal==null
				|| imgRules==null || imgLifeNums==null){
			try {
				imgBlood = Image.createImage("/blood.png");
				imgBlood2 = Image.createImage("/blood2.jpg");
				imgGk = Image.createImage("/gk.jpg");
				imgMedal = Image.createImage("/medal.png");
				imgRules = Image.createImage("/rules.jpg");
				imgLifeNums = Image.createImage("/lifenums.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(currBoold>=10){
			g.drawRegion(imgBlood, 0, 0, 10, 16, 0, 60+Abs_Coords_X, 500+Abs_Coords_Y, TopLeft);
		}
		if(currBoold>20){
			g.drawRegion(imgBlood2, 0, 0, currBoold-20, 16, 0, 68+Abs_Coords_X, 500+Abs_Coords_Y, TopLeft);
		}
		if(currBoold==90){
			g.drawRegion(imgBlood, 20, 0, 10, 16, 0, 137+Abs_Coords_X, 500+Abs_Coords_Y, TopLeft);
		}
		engine.setFont(24);
		g.setColor(255, 255, 255);
		/*�ؿ�*/
		g.drawRegion(imgGk, 25*(level-1), 0, 25, 28, 0, 585+Abs_Coords_X, 13+Abs_Coords_Y, TopLeft);
		/*��ǰѪ��*/
		drawNum(g, own.nonceLife, 92+Abs_Coords_X, 498+Abs_Coords_Y);
		//g.drawString(String.valueOf(own.nonceLife)+"/"+String.valueOf(limitLife), 85, 498, TopLeft);
		/*�÷ֺͻ�������*/
		drawNum(g, own.scores, 230+Abs_Coords_X, 498+Abs_Coords_Y);
		drawNum(g, own.eatCount2, 403+Abs_Coords_X, 498+Abs_Coords_Y);
		for(int i=0;i<own.lifeNum;i++){
			g.drawImage(imgLifeNums, i*imgLifeNums.getWidth()+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		}
		
		/*��������*/
		g.setColor(255, 255, 255);
		engine.setFont(15);
		/*TextView.showSingleLineText(g, String.valueOf(propety.energyPropNum), 498, 260, 18, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.hidePropNum), 565, 260, 18, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.slowPropNum), 498, 326, 18, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.airDropPropNum), 565, 326, 18, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.dartlePropNum), 498, 391, 18, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.laserPropNum), 565, 391, 18, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.medigelPropNum), 498, 456, 18, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.limitBooldPropNum), 565, 456, 18, 16, 1);*/
		
		TextView.showSingleLineText(g, String.valueOf(propety.energyPropNum), 494+Abs_Coords_X, 260+Abs_Coords_Y, 24, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.hidePropNum), 561+Abs_Coords_X, 260+Abs_Coords_Y, 24, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.slowPropNum), 494+Abs_Coords_X, 326+Abs_Coords_Y, 24, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.airDropPropNum), 561+Abs_Coords_X, 326+Abs_Coords_Y, 24, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.dartlePropNum), 494+Abs_Coords_X, 391+Abs_Coords_Y, 24, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.laserPropNum), 561+Abs_Coords_X, 391+Abs_Coords_Y, 24, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.medigelPropNum), 494+Abs_Coords_X, 456+Abs_Coords_Y, 24, 16, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.limitBooldPropNum), 561+Abs_Coords_X, 456+Abs_Coords_Y, 24, 16, 1);
		/*��ѫ��*/
		drawMedal(g, 500+Abs_Coords_X, 187+Abs_Coords_Y);
		/*��ʾ��Ϣ*/
		if(!msg.equals("") && msgTime2-msgTime<3){
			int color = g.getColor();
			g.setColor(0xffffff);
			engine.setFont(19);
			Font currFont = engine.getFont();//Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_LARGE);
			int x = 100+imgRules.getWidth()/2 - currFont.stringWidth(msg)/2;
			g.drawImage(imgRules, 100+Abs_Coords_X, 195+Abs_Coords_Y, TopLeft);
			g.drawString(msg, x+Abs_Coords_X, 200+Abs_Coords_Y, TopLeft);
			g.setColor(color);
		}
		engine.setDefaultFont();
	}
	/*��Ϸ�е�����*/
	private void drawNum(Graphics g, int num, int x, int y) {
		if(imgNumber2==null){
			try {
				imgNumber2 = Image.createImage("/number2.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String number = String.valueOf(num);
		for (byte i = 0; i < number.length(); i++) {
			g.drawRegion(imgNumber2, (number.charAt(i) - '0') * 11, 0, 11, 19,
					0, x + i * (11 + 1), y, 0);
		}
	}
	
	/*�ؿ�ѡ�����*/
	public void drawSelectLevel(Graphics g, int level){
		if(imgLevel==null || imgMain4==null || imgBiglevel==null 
				|| imgPrompt==null ){
			try {
				imgLevel = Image.createImage("/level.png");
				imgMain4 = Image.createImage("/main4.jpg");
				imgBiglevel = Image.createImage("/biglevel.png");
				imgPrompt = Image.createImage("/prompt.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try{
			g.drawImage(imgMain4, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
			g.drawRegion(imgLevel, 0, 0, 51, 22, 0, 220+Abs_Coords_X, 165+Abs_Coords_Y, TopLeft);    //1
			g.drawRegion(imgLevel, 102, 0, 51, 22, 0, 377+Abs_Coords_X, 168+Abs_Coords_Y, TopLeft);   //2
			g.drawRegion(imgLevel, 51, 0, 51, 22, 0, 485+Abs_Coords_X, 265+Abs_Coords_Y, TopLeft);   //3
			g.drawRegion(imgLevel, 153, 0, 51, 22, 0, 267+Abs_Coords_X, 325+Abs_Coords_Y, TopLeft);  //4
			g.drawRegion(imgBiglevel, 0, 0, 84, 34, 0, 326+Abs_Coords_X, 230+Abs_Coords_Y, TopLeft); //5
			if(promptFlag<=3){
				promptFlag++;
			}else{
				if(!isPrompt){
					promptIndex = para[level-1][1];
					isPrompt=true;
				}else{
					promptIndex = para[level-1][1]-10;
					isPrompt=false;
				}
				promptFlag = 0;
			}
			/*��ǰ�ؿ�*/
			g.drawRegion(imgPrompt, 0, 0, imgPrompt.getWidth(), imgPrompt.getHeight(), 0, para[level-1][0]+Abs_Coords_X, promptIndex+Abs_Coords_Y, TopLeft);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*��������*/
	public void drawHelp(Graphics g, int index){
		if(imgHelp==null||imgHelp2==null){
			try {
				imgHelp = Image.createImage("/help.jpg");
				imgHelp2 = Image.createImage("/help2.jpg");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(index==0){
			g.drawImage(imgHelp, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		}else{
			g.drawImage(imgHelp2, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		}
	}
	
	/*���ͨ����Ϣ*/
	public int tempY=-200;
	public void drawUserGameInfo(Graphics g, int passState, int level, Role own, int index, int difficultLevel){
		if(imgMain3==null || imgGameInfo==null || imgPass==null || imgOver==null 
				|| imgMedal==null || imgPassBg==null || imgPassText==null || imgPassFireWork==null
				|| imgPassSelect==null){
			try {
				imgMain3 = Image.createImage("/main3.jpg");
				imgGameInfo = Image.createImage("/gameinfo.jpg");
				imgPass = Image.createImage("/pass.jpg");
				imgOver = Image.createImage("/over.jpg");
				imgMedal = Image.createImage("/medal.png");
				imgPassBg = Image.createImage("/pass_bg.png");
				imgPassText = Image.createImage("/pass_text.png");
				imgPassFireWork = Image.createImage("/pass_firework.png");
				imgPassSelect = Image.createImage("/pass_select.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String str = "";
		g.drawImage(imgMain3, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		if(passState==-1){
			g.drawRegion(imgGameInfo, 0, 0, imgGameInfo.getWidth(), imgGameInfo.getHeight(), 0, 85+Abs_Coords_X, 140+Abs_Coords_Y, TopLeft);
			g.drawImage(imgOver, 266+Abs_Coords_X, 158+Abs_Coords_Y, TopLeft);
			g.drawRegion(imgPassSelect, index*193, 0, 193, 46, 0, 91+Abs_Coords_X, 420+Abs_Coords_Y, TopLeft);
			g.drawRegion(imgPassSelect, (index==0?1:0)*193, 92, 193, 46, 0, 350+Abs_Coords_X, 420+Abs_Coords_Y, TopLeft);
			info(g, level, own, str);
		}else{
			if(passState==0){
				g.drawRegion(imgGameInfo, 0, 0, imgGameInfo.getWidth(), imgGameInfo.getHeight(), 0, 85+Abs_Coords_X, 140+Abs_Coords_Y, TopLeft);
				g.drawImage(imgPass, 286+Abs_Coords_X, 158+Abs_Coords_Y, TopLeft);
				str="��ȷ�ϼ�������һ��!";
				info(g, level, own, str);
			}else{
				//str="��ȷ�ϼ��������а�鿴����!";
				g.drawImage(imgPassBg, 175+Abs_Coords_X, tempY+Abs_Coords_Y, TopLeft);
				if(tempY<=180){
					tempY += 35;
				}else{
					g.drawRegion(imgPassText, 543*5, 0, 543, 175, 0, 50+Abs_Coords_X, 235+Abs_Coords_Y, TopLeft);
					g.drawRegion(imgPassText, textIndex*543, 0, 543, 175, 0, 50+Abs_Coords_X, 235+Abs_Coords_Y, TopLeft);
					if(textIndex<5){
						if(textFlag<=3){
							textFlag++;
						}else{
							textIndex=textIndex+1;
							textFlag=0;
						}
					}else if(fireCount<=2){
						if(fireFlag<=2){
							fireFlag++;
						}else{
							fireIndex=(fireIndex+1)%4;
							fireFlag=0;
							if(fireIndex==1){
								isFire2 = true;
							}
							if(fireIndex==2){
								isFire3 = true;
							}
							if(fireIndex==3){
								isFire4 = true;
								mapx1 = coordinate[0][RandomValue.getRandInt(0, 4)];
								mapy1 = coordinate[1][RandomValue.getRandInt(0, 4)];
								fireCount++;
							}
						}
						if(isFire2){
							if(fireFlag2<=2){
								fireFlag2++;
							}else{
								fireIndex2=(fireIndex2+1)%4;
								fireFlag2=0;
								if(fireIndex2==3){
									isFire2=false;
									mapx2 = coordinate[0][RandomValue.getRandInt(0, 4)];
									mapy2 = coordinate[1][RandomValue.getRandInt(0, 4)];
								}
							}
							g.drawRegion(imgPassFireWork, fireIndex2*341, 0, 341, 354, 0, mapx2+Abs_Coords_X, mapy2+Abs_Coords_Y, TopLeft);
						}
						if(isFire3){
							if(fireFlag3<=2){
								fireFlag3++;
							}else{
								fireIndex3=(fireIndex3+1)%4;
								fireFlag3=0;
								if(fireIndex3==3){
									isFire3=false;
									mapx3 = coordinate[0][RandomValue.getRandInt(0, 4)];
									mapy3 = coordinate[1][RandomValue.getRandInt(0, 4)];
								}
							}
							g.drawRegion(imgPassFireWork, fireIndex3*341, 0, 341, 354, 0, mapx3+Abs_Coords_X, mapy3+Abs_Coords_Y, TopLeft);
						}
						if(isFire4){
							if(fireFlag4<=2){
								fireFlag4++;
							}else{
								fireIndex4=(fireIndex4+1)%4;
								fireFlag4=0;
								if(fireIndex4==3){
									isFire4=false;
									mapx4 = coordinate[0][RandomValue.getRandInt(0, 4)];
									mapy4 = coordinate[1][RandomValue.getRandInt(0, 4)];
								}
							}
							g.drawRegion(imgPassFireWork, fireIndex4*341, 0, 341, 354, 0, mapx4+Abs_Coords_X, mapy4+Abs_Coords_Y, TopLeft);
						}
						g.drawRegion(imgPassFireWork, fireIndex*341, 0, 341, 354, 0, mapx1+Abs_Coords_X, mapy1+Abs_Coords_Y, TopLeft);
					}else{
						isFireOver = true; //�̻�����
						if(difficultLevel==2){ //û����һ���Ѷ�����ʾ���¿�ʼ��Ϸ
							g.drawRegion(imgPassSelect, index*193, 0, 193, 46, 0, 91+Abs_Coords_X, 420+Abs_Coords_Y, TopLeft);
						}else{
							g.drawRegion(imgPassSelect, index*193, 46, 193, 46, 0, 91+Abs_Coords_X, 420+Abs_Coords_Y, TopLeft);
						}
						g.drawRegion(imgPassSelect, (index==0?1:0)*193, 92, 193, 46, 0, 350+Abs_Coords_X, 420+Abs_Coords_Y, TopLeft);
					}
				}
			}
		}
	}
	/*������Ϣ*/
	private void info(Graphics g, int level, Role own, String str){
		g.setColor(255, 255, 255);
		Font largeFont = Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_LARGE);
		engine.setFont(19);
		int x = screenW/2-largeFont.stringWidth(str)/2;
		g.drawString(str, x+Abs_Coords_X, 482+Abs_Coords_Y, TopLeft);
		
		g.setColor(28, 213, 233);
		g.drawString(String.valueOf(level), 300+Abs_Coords_X, 208+Abs_Coords_Y, TopLeft);
		g.drawString(String.valueOf(own.scores), 300+Abs_Coords_X, 238+Abs_Coords_Y, TopLeft);
		g.drawString(String.valueOf(own.eatCount), 300+Abs_Coords_X, 268+Abs_Coords_Y, TopLeft);
		g.drawString(String.valueOf(own.harm), 300+Abs_Coords_X, 298+Abs_Coords_Y, TopLeft);
		String str2 = String.valueOf(((Weapon.hitNumber/Weapon.bombAmount)*100));
		//System.out.println("str2:"+str2);
		if(str2.equalsIgnoreCase("nan")){
			str2="0";
		}
		if(str2.length()>2){
			g.drawSubstring(str2, 0, 2, 300+Abs_Coords_X, 328+Abs_Coords_Y, TopLeft);
		}else{
			g.drawSubstring(str2, 0, str2.length(), 300+Abs_Coords_X, 328+Abs_Coords_Y, TopLeft);
		}
		g.drawString("%", 320+Abs_Coords_X, 328+Abs_Coords_Y, TopLeft);
		//��ѫ��
		drawMedal(g, 295+Abs_Coords_X, 358+Abs_Coords_Y);
		engine.setDefaultFont();
	}
	/*ѫ��*/
	private void drawMedal(Graphics g, int x_dest, int y_dest){
		int x = x_dest, y = y_dest, x1=0, x2=0, x3=0, temp=0;
		for(int l=0;l<SubmarineGameEngine.medal3;l++){
			x1 = l*12;
			g.drawRegion(imgMedal, imgMedal.getWidth()/3, 0, imgMedal.getWidth()/3, imgMedal.getHeight(), 0, x+x1, y, TopLeft);
		}
		if(SubmarineGameEngine.medal3<1){
			x2 = x;
		}else{
			x2 = x+x1+12;
		}
		for(int k=0;k<SubmarineGameEngine.medal2;k++){
			temp=k*12;
			g.drawRegion(imgMedal, 2*imgMedal.getWidth()/3, 0, imgMedal.getWidth()/3, imgMedal.getHeight(), 0, x2+temp, y, TopLeft);
		}
		if(SubmarineGameEngine.medal2<1){
			x3 = x2;
		}else{
			x3 = x2+temp+12;
		}
		for(int j=0;j<SubmarineGameEngine.medal;j++){
			g.drawRegion(imgMedal, 0, 0, imgMedal.getWidth()/3, imgMedal.getHeight(), 0, x3+j*11, y, TopLeft);
		}
	}
	
	/*��Ϸ������*/
	public void drawGameIntro(Graphics g){
		if(imgMain3==null || imgCallBoard==null || imgPrompt2==null){
			try {
				imgMain3 = Image.createImage("/main3.jpg");
				imgCallBoard = Image.createImage("/callboard.png");
				imgPrompt2 = Image.createImage("/prompt2.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		g.drawImage(imgMain3, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		g.drawImage(imgCallBoard, 105+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		g.drawImage(imgPrompt2, 120+Abs_Coords_X, 138+Abs_Coords_Y, TopLeft);
		g.setColor(28, 213, 233);
		engine.setFont(19);
		String info = "";
		for(int i=0;i<gameIntro.length;i++){
			info += gameIntro[i];
		}
		TextView.showMultiLineText(g, info, 15, 134+Abs_Coords_X, 155+Abs_Coords_Y, 380, 240);
		engine.setDefaultFont();
	}
	
	/*�̳ǽ���*/
	public void drawShop(Graphics g, int shopX, int shopY, Propety propety){
		if(imgShop==null){
			try {
				imgShop = Image.createImage("/shop.jpg");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		engine.setFont(19);
		g.drawImage(imgShop, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		if(shopX<2){
			//g.drawImage(imgShopSelect, 143+shopX*220, 127+shopY*100, TopLeft);
			DrawUtil.drawRect(g, 145+shopX*220+Abs_Coords_X, 127+shopY*100+Abs_Coords_Y, 78, 32, 2, 0XFFFF00);
			
			//��ʾ������Ϣ
			g.setColor(28, 213, 233);
			TextView.showMultiLineText(g, desc[shopY][shopX], 5, 478+Abs_Coords_X, 90+Abs_Coords_Y, 143, 180);
		}else{
			//g.drawImage(imgShopSelect2, 472, 343, TopLeft);
			DrawUtil.drawRect(g, 472+Abs_Coords_X, 344+Abs_Coords_Y, 145, 45, 2, 0XFFFF00);
		}
		g.setColor(28, 213, 233);
		g.drawString(String.valueOf(engine.getEngineService().getBalance()), 540+Abs_Coords_X, 293+Abs_Coords_Y, TopLeft);
		
		/*���߼۸�*/
		drawShopNum(g,20,180+Abs_Coords_X,99+Abs_Coords_Y);
		drawShopNum(g,30,180+Abs_Coords_X,199+Abs_Coords_Y);
		drawShopNum(g,40,180+Abs_Coords_X,299+Abs_Coords_Y);
		drawShopNum(g,50,180+Abs_Coords_X,399+Abs_Coords_Y);
		drawShopNum(g,30,402+Abs_Coords_X,99+Abs_Coords_Y);
		drawShopNum(g,30,402+Abs_Coords_X,199+Abs_Coords_Y);
		drawShopNum(g,40,402+Abs_Coords_X,299+Abs_Coords_Y);
		drawShopNum(g,60,402+Abs_Coords_X,399+Abs_Coords_Y);
		
		/*��������*/
		g.setColor(255, 255, 255);
		/*TextView.showSingleLineText(g, String.valueOf(propety.energyPropNum), 72, 110, 25, 29, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.hidePropNum), 293, 110, 25, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.slowPropNum), 72, 210, 25, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.airDropPropNum), 293, 210, 25, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.dartlePropNum), 72, 310, 25, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.laserPropNum), 293, 310, 25, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.medigelPropNum), 72, 410, 25, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.limitBooldPropNum), 293, 410, 25, 25, 1);*/
		
		TextView.showSingleLineText(g, String.valueOf(propety.energyPropNum), 68+Abs_Coords_X, 110+Abs_Coords_Y, 29, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.hidePropNum), 291+Abs_Coords_X, 110+Abs_Coords_Y, 29, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.slowPropNum), 68+Abs_Coords_X, 210+Abs_Coords_Y, 29, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.airDropPropNum), 291+Abs_Coords_X, 210+Abs_Coords_Y, 29, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.dartlePropNum), 68+Abs_Coords_X, 310+Abs_Coords_Y, 29, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.laserPropNum), 291+Abs_Coords_X, 310+Abs_Coords_Y, 29, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.medigelPropNum), 68+Abs_Coords_X, 410+Abs_Coords_Y, 29, 25, 1);
		TextView.showSingleLineText(g, String.valueOf(propety.limitBooldPropNum), 291+Abs_Coords_X, 410+Abs_Coords_Y, 25, 25, 1);
		engine.setDefaultFont();
	}
	/*�̳��е�����*/
	private void drawShopNum(Graphics g, int num, int x, int y) {
		if(imgNumber2==null){
			try {
				imgNumber2 = Image.createImage("/number2.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String number = String.valueOf(num);
		for (byte i = 0; i < number.length(); i++) {
			g.drawRegion(imgNumber2, (number.charAt(i) - '0') * 11, 0, 11, 19,
					0, x + i * (11 + 1), y, 0);
		}
	}
	
	/*���߹���״̬*/
	public void drawPurchaseState(Graphics g, boolean isEnoughMoney, int purchaseIndex){
		if(imgPurchaseSuccess==null || imgPurchaseFail==null){
			try {
				imgPurchaseSuccess = Image.createImage("/purchaseSuccess.png");
				imgPurchaseFail = Image.createImage("/purchaseFail.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(isEnoughMoney){
			g.drawImage(imgPurchaseSuccess, 250+Abs_Coords_X, 228+Abs_Coords_Y, TopLeft);
		}else{
			g.drawImage(imgPurchaseFail, 172+Abs_Coords_X, 201+Abs_Coords_Y, TopLeft);
			//g.drawImage(imgPurchaseSelect2, 185+(purchaseIndex*224), 254, TopLeft);
			DrawUtil.drawRect(g, 185+(purchaseIndex*224)+Abs_Coords_X, 254+Abs_Coords_Y, 51, 30, 2, 0XFFFF00);
		}
	}
	
	/*��ֵ����
	public void drawRecharge(Graphics g, int index){
		if(imgRecharge==null){
			try {
				imgRecharge = Image.createImage("/recharge.jpg");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		g.drawImage(imgRecharge, 0, 0, TopLeft);
		//g.drawImage(imgRechargeSelect, 50+index*136, 210, TopLeft);
		DrawUtil.drawRect(g, 50+index*136, 210, 77, 34, 2, 0XFFFF00);
	}
	
	��ֵ״̬����
	public void drawRechargeSuccess(Graphics g, boolean isSuccess){
		if(imgRechargeSuccess==null || imgRechargeFail==null){
			try {
				imgRechargeSuccess = Image.createImage("/rechargeSuccess.png");
				imgRechargeFail = Image.createImage("/rechargeFail.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(isSuccess){
			g.drawImage(imgRechargeSuccess, 175, 175, TopLeft);
		}else{
			g.drawImage(imgRechargeFail, 175, 175, TopLeft);
		}
		
	}
	*/
	
	/*��Ϸ����*/
	public void drawRankList(Graphics g, GameRanking[] gameRanking){
		if(imgRanking==null||imgMedal==null){
			try {
				imgRanking = Image.createImage("/rankList.jpg");
				imgMedal = Image.createImage("/medal.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		g.drawImage(imgRanking, 0+Abs_Coords_X, 0+Abs_Coords_Y, TopLeft);
		g.setColor(190, 255, 255);
		engine.setFont(19);
		String ownRank="��������!";
		if(gameRanking!=null){
			sortByMedalNum(gameRanking); //����
			for(int i=0;i<gameRanking.length;++i){
				int ranking = gameRanking[i].getRanking();
				String id = gameRanking[i].getUserId();
				String str = "";
				if(id.length()>=4){
					str = id.substring(0, 4)+"****";
				}else{
					str = id;
				}
				String scores = String.valueOf(gameRanking[i].getScores());
				String hitNum = String.valueOf(gameRanking[i].getPlayDuration());
				String medalNum = gameRanking[i].getRemark();
				if(id.equals(engine.getEngineService().getUserId())){
					ownRank = String.valueOf(gameRanking[i].getRanking());
				}
				initMedalNum(medalNum);
				TextView.showSingleLineText(g, String.valueOf(ranking), 35+Abs_Coords_X, 122+(i*35)+Abs_Coords_Y, 100, 35, 1);
				TextView.showSingleLineText(g, str, 135+Abs_Coords_X, 122+(i*35)+Abs_Coords_Y, 125, 35, 1);
				TextView.showSingleLineText(g, scores, 260+Abs_Coords_X, 122+(i*35)+Abs_Coords_Y, 100, 35, 1);
				TextView.showSingleLineText(g, hitNum, 360+Abs_Coords_X, 122+(i*35)+Abs_Coords_Y, 105, 35, 1);
				/*int idW = 104-g.getFont().stringWidth(id)/2;
				int scoresW = 260-g.getFont().stringWidth(scores)/2;
				int hitNumW = 390-g.getFont().stringWidth(hitNum)/2;
				int y = 130+(i*35);
				g.drawString(id, idW, y, TopLeft);
				g.drawString(scores, scoresW, y, TopLeft);
				g.drawString(hitNum, hitNumW, y, TopLeft);*/
				//��ѫ��
				drawMedal(g, 480+Abs_Coords_X, 130+(i*35)+Abs_Coords_Y);
			}
		}
		g.drawString(ownRank, 140+Abs_Coords_X, 498+Abs_Coords_Y, TopLeft);
		engine.setDefaultFont();
	}
	/*������ͬʱ��ѫ����������*/
	private void sortByMedalNum(GameRanking[] gameRanking){
		GameRanking temp;
		for(int i=0;i<gameRanking.length;i++){
			if(i!=gameRanking.length-1){
				if(gameRanking[i].getScores()==gameRanking[i+1].getScores()){
					if(Integer.parseInt(gameRanking[i].getRemark())<Integer.parseInt(gameRanking[i+1].getRemark())){
						temp = gameRanking[i];
						gameRanking[i] = gameRanking[i+1];
						gameRanking[i+1] = temp;
					}
				}
			}
		}
	}
	
	/*����ѫ������*/
	private void initMedalNum(String str){
		int medalNum = Integer.parseInt(str);
		SubmarineGameEngine.medal3 = medalNum/16;
		medalNum = medalNum-SubmarineGameEngine.medal3*16;
		SubmarineGameEngine.medal2 = medalNum/4;
		medalNum = medalNum-SubmarineGameEngine.medal2*4;
		SubmarineGameEngine.medal = medalNum;
		/*ÿ�ĸ�Сѫ�»���һ������ѫ��*/
		if(SubmarineGameEngine.medal>=4){
			SubmarineGameEngine.medal2++;
			SubmarineGameEngine.medal -= 4;
		}
		/*ÿ�ĸ���ѫ�»���һ����ѫ��*/
		if(SubmarineGameEngine.medal2>=4){
			SubmarineGameEngine.medal3++;
			SubmarineGameEngine.medal2 -= 4;
		}
	}
	
	/*�幺��״̬����ͼƬ*/
	public void clearPurchaseState(){
		if(imgPurchaseSuccess!=null || imgPurchaseFail!=null){
			imgPurchaseSuccess=null;
			imgPurchaseFail=null;
		}
	}
	
	/*���ֵ״̬����ͼƬ*/
	public void clearRechargeState(){
		if(imgRechargeSuccess!=null || imgRechargeFail!=null){
			imgRechargeSuccess=null; imgRechargeFail=null;
		}
	}
	
	/*���������ͼƬ*/
	public void clearHelp(){
		if(imgHelp!=null||imgHelp2!=null){
			imgHelp=null;imgHelp2=null;
		}
	}
	
	/*���ֵ����*/
	public void clearRecharge(){
		if(imgRecharge!=null){
			imgRecharge = null;
		}
	}
	
	/*����Ϸ������*/
	public void clearGameIntro(){
		if(imgMain3!=null || imgPrompt2!=null || imgCallBoard!=null){
			imgMain3=null; imgPrompt2=null;
			imgCallBoard=null;
		}
	}
	
	/*�����н���ͼƬ*/
 	public void clearGameRanking(){
		if(imgRanking!=null||imgMedal!=null){
			imgRanking = null;imgMedal=null;
		}
	}
	/*���̳ǽ���*/
 	public void clearShop(){
 		if(imgShop!=null){
 			imgShop = null;
		}
 	}
 	
	/*�����ͨ�ؽ���ͼƬ*/
	public void clearGamePass(){
		if(imgMain3!=null || imgGameInfo!=null || imgPass!=null || imgOver!=null||imgMedal!=null
				||imgPassBg!=null||imgPassText!=null||imgPassFireWork!=null||imgPassSelect!=null){
			imgMain3=null; imgGameInfo=null;
			imgPass=null; imgOver=null;
			imgMedal=null;imgPassBg=null;
			imgPassText=null;imgPassFireWork=null;
			imgPassSelect=null;
		}
	}
	
	/*���������ͼƬ*/
	public void clearMain(){
		if(imgMain1 != null || imgMain2 != null){
			imgMain1 = null;
			imgMain2 = null;
		}
	}
	
	/*����Ϸ�е�ͼƬ*/
	public void clearPlaying(){
		if(imgMapUp != null || imgKa != null || imgMenu != null
			||	imgBlood!=null || imgBlood2 !=null || imgGk != null || imgNumber2 != null
			|| imgMapCenter!=null || imgMapDown!=null || imgMapRight!=null || imgBoat!=null
			|| imgIceBerg!=null || imgMedal!=null||imgRules!=null||imgWarning!=null){
			imgMapUp = null; imgMedal=null;
			imgBlood = null;imgMenu = null;
			imgBlood2 = null;imgKa = null;
		    imgGk = null; imgNumber2 = null;
		    imgMapCenter=null; imgMapDown=null;
		    imgMapRight=null; imgBoat=null;
		    imgIceBerg=null; imgWarning=null;
		    imgRules=null;
		}
	}
	
	/*��ؿ�ѡ�����*/
	public void clearSelectLevel(){
		if(imgLevel!=null || imgMain4!=null || imgBiglevel!=null 
				|| imgPrompt!=null){
			imgLevel = null;imgBiglevel=null;
			imgMain4 = null;
			imgPrompt=null;
		}
	}
	
	/*�形ͧѡ������ͼƬ*/
	public void clearSelectSubmarine(){
		if (imgInfo!=null || imgConfirm!=null || imgDirection!=null || imgLock!=null
				|| imgMain3!=null || imgSubmirine!=null || imgPurchaseIcon!=null){
			
			 imgInfo=null; imgConfirm=null; imgDirection=null; 
			 imgMain3=null; imgSubmirine=null;
			 imgLock=null; imgPurchaseIcon=null;
		}
	}
	/*���Ѷ�ѡ�����*/
	public void clearDifficultLevel(){
		if(imgDifficultLevel2!=null||imgMain1!=null){
			imgDifficultLevel2=null;imgMain1=null;
		}
	}
	/*��Ǳͧ��ʾͼƬ*/
	public void clearPrompt(){
		if(imgPrompt2!=null){
			imgPrompt2=null;
		}
	}
	
	/*ͨ�غ��ʼ����*/
	public void initData(){
		tempY=-200;
		textFlag=0; textIndex=0;
		fireFlag=0; fireIndex=0;
		fireFlag2=0; fireIndex2=0;
		fireFlag3=0; fireIndex3=0;
		fireFlag4=0; fireIndex4=0;
	}
}
