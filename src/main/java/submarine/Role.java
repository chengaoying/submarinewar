package submarine;

/**
 * ��ɫ���� 
 * @author xiaochen
 *
 */
public class Role{
	
	int id; 			//ID  (�û���ͧID:100-; �ط���ͧID:1-10; ����ID:11-30; Boss ID:31-40)
	int mapx; 			//�ڵ�ͼ�ϵĺ�����
	int mapy; 			//�ڵ�ͼ�ϵ�������
	int width;			//������
	int height;			//����߶�
	int frame; 			//֡
	int direction; 		//�ƶ�����
	int status;  		//״̬(0�״̬, 1��״̬)
	int nonceLife;		//����ֵ
	int limitLife;		//����ֵ����
	int money; 			//�����
	int lifeNum; 		//������
	float speed;		//�ƶ��ٶ�
	int scores; 		//����
	int scores2;		//���ڼ��㹦ѫ�Ļ���
	int skill; 			//����
	int eatYellow;		//�����Ǳͧ��
	int eatRed;			//�����Ǳͧ��
	int eatBlue;		//������Ǳͧ��
	int eatBlack;		//�����Ǳͧ��
	int eatJisu;		//������Ǳͧ��
	int attack; 		//NPC��ͨ������
	int eatCount;		//����Ǳͧ������
	int eatCount2;		//����BOSS��Ҫ����������
	int harm;			//���ܵ��˺�
	
	
	Role role;   			//�״������е�npc
	
}
