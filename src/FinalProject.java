import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FinalProject extends JFrame {
	//ObjeectOutputStream oos = new ObjectOutpuutStream(new FileOutputStream(""))
	TimeThread timeThread = new TimeThread();
	String imagePath = "";
	String filePath ="";
	public int m =0;
	public int b =0;
	public int w =0;
	int flag =0;
	int whatareyoudoing =0;
	Item now = null;
	int index=-1;
	String [] movies =new String[10];
	String [] books= new String[10];
	String [] whole= new String[10];
	JList<String> movieList = new JList <String> (movies);
	JList<String> bookList = new JList <String> (books);	
	JList<String> wholeList = new JList <String> (whole);
	JList<String> starList = new JList <String> ();
	
	
	
	//��ü ȭ�鿡���� �гε� 
	JLabel text = new JLabel("                My Notes");
	
	JPanel time = new JPanel(); 	//�ð� ���?
	JButton add = new JButton("�߰�");
	JButton edit = new JButton("����");
	JButton delete = new JButton("����");
	
	JLabel wLabel = new JLabel();	//whole
	JLabel mLabel = new JLabel();	//movie label
	JLabel bLabel = new JLabel();	//book label
	JLabel sLabel = new JLabel();	//search label
	
	JPanel nPanel = new JPanel(); //north panel
	JPanel ePanel = new JPanel();	//east panel
	JPanel wPanel = new JPanel();	//west panel
	JPanel bpanel1 = new JPanel();	//west button1 panel
	JPanel bpanel2 = new JPanel(); //east button2 panel 
	//JPanel ePanel0 = new JPanel();
	JPanel ePanel1 = new JPanel();
	JPanel ePanel2 = new JPanel();
	JPanel dpanel = new JPanel();	//detail panel
	JPanel spanel = new JPanel();	//summary panel
	JPanel cpanel = new JPanel();	//comments panel

	
	JPanel wWholePanel = new JPanel();
	JPanel wMoviePanel = new JPanel();
	JPanel wBookPanel = new JPanel();
	JPanel wSearchPanel = new JPanel();
	
	JTextField choosertf = new JTextField(imagePath,6);
 
	//�̹��� ������
	ImageIcon icon = new ImageIcon(imagePath);
	//�̹��� ��ü ����
	Image img = icon.getImage();
	JLabel imgLabel = new JLabel(imagePath);
	private imagePanel imgPanel = new imagePanel();
	// �󼼺��� ���� ���
	
	JPanel detailInf = new JPanel();
	JPanel detailInfLabel = new JPanel();
	JPanel detailInformationPanel = new JPanel();
	JTextArea summaryArea = new JTextArea(5,55);
	JTextArea commentsArea = new JTextArea(5,55);
	Border detailBorder = BorderFactory.createTitledBorder("�� ����");
	Border summaryBorder = BorderFactory.createTitledBorder("�ٰŸ�");
	Border commentsBorder = BorderFactory.createTitledBorder("������");
	
	MyModalDialog dialog = new MyModalDialog(this,"�Է�");	//�߰� ������ �߻��ϴ� �Է� �˾� 
	
	//�˻��ϱ� 
	JPanel northSearchPanel = new JPanel();
	JPanel listSearchPanel = new JPanel();
	String [] searchComboList = {"����","����"};
	JComboBox <String> searchComboBox = new JComboBox <String> (searchComboList);
	JTextField searchtf = new JTextField("");
	JButton searchbt = new JButton("�˻�");
	
	//��� ���̾� ������ �гε� 
	

	public FinalProject() throws Exception ,NullPointerException{
		setTitle("JAVA 004 1912899 �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		
		Container c = getContentPane();			//����Ʈ �� �θ��� 
		c.setLayout(new BorderLayout());			//���� �ø��� �; �Ϻη� ���� 					
		wWholePanel.add(wholeList);
		wMoviePanel.add(movieList);
		wBookPanel.add(bookList);
		text.setFont(new Font("Arial",Font.ITALIC +Font.BOLD,25));
		text.setForeground(Color.BLUE);
		time.add(new TimeThread());
		//nPanel.setLayout(new GridLayout(1,2));
		wPanel.setPreferredSize(new Dimension(250,500));
		nPanel.setLayout(new BorderLayout());
		wPanel.setLayout(new BorderLayout());
		ePanel.setLayout(new BorderLayout());
		ePanel1.setLayout(new GridLayout(2,1));	//east panel �󼼺���� �ٰŸ� ������ ��� ���� �г�
		ePanel2.setLayout(new GridLayout(2,1));	//eastpanel �ٰŸ��� ������ ���� �г� 
		
		nPanel.add(text,BorderLayout.CENTER);		//���� ��Ʈ�� ��¥ �߰��ϴ� �г�
		nPanel.add(time,BorderLayout.EAST);
		ePanel1.setBorder(detailBorder);	//���� �޾��ֱ�
		spanel.setBorder(summaryBorder);
		cpanel.setBorder(commentsBorder);
		spanel.add(summaryArea);	//textarea �ٿ��ֱ�
		cpanel.add(commentsArea);	//textarea �ٿ��ֱ�

		JTabbedPane pane = createTabbedPane();
		pane.setTabPlacement(JTabbedPane.TOP);
		wPanel.add(pane,BorderLayout.CENTER);
	
		ePanel2.add(spanel);	//epanel2�� summary�� comments�޾��ֱ�
		ePanel2.add(cpanel);
		ePanel1.add(dpanel);	//detail �޾��ְ�
		ePanel1.add(ePanel2);	//summary�� comments ����ִ� epanel2 �޾��ֱ� 
		ePanel.add(ePanel1,BorderLayout.CENTER);

		add.addActionListener(new ActionListener(){	//�߰� ��ư ������ dialog �г� �θ��� //�߰�
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		bpanel1.add(add);	
		
		
		edit.addActionListener(new ActionListener() {//����
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				whatareyoudoing=1;
				
			}
		});
		bpanel2.add(edit);	
		
		
		delete.addActionListener(new ActionListener() {//����
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?","���� Ȯ��",JOptionPane.YES_NO_OPTION);	
				if(result == JOptionPane.CLOSED_OPTION) { //����ڰ� ���� ���̿��� ���� ���� ���̾�α� â�� ���� ��� 
					
				}
				else if (result == JOptionPane.YES_OPTION) {	//����ڰ� ���� ������ ��� 
					itemCollections.deleteItem(now.getName());
				}
				else {	//����ڰ� �ƴϿ��� ������ ��� 
					
				}
			}
		});
		bpanel2.add(delete);	
		
		wPanel.add(bpanel1,BorderLayout.SOUTH);	
		ePanel.add(bpanel2,BorderLayout.SOUTH);

		
		c.add(nPanel,BorderLayout.NORTH);
		c.add(wPanel,BorderLayout.WEST);
		c.add(ePanel,BorderLayout.CENTER);
		
		setSize(800,700);				//������ ���� 
		setVisible(true);
	}
	

	class imagePanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (imagePath=="") {
				g.drawLine(10, 10, 220, 220);
				g.drawLine(220, 10, 10, 220);
				g.drawString("�̹��� ����", 90, 120);
			}
			else {
				g.drawImage(img,10,10,210,210,this);
			}
		}
	}
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);

		//�˻��ϱ� �г� 
		//listSearchPanel.add(wholeList);
		wholeList.addListSelectionListener(new ListSelectionListener(){
		
			public void valueChanged(ListSelectionEvent e) {
				index = wholeList.getSelectedIndex();
				if (index ==-1 ){
					
				}
				else {
				detailInf = new JPanel();
				detailInfLabel = new JPanel();
				//detailInformationPanel = new JPanel();
				//dpanel = new JPanel();
				String listname = (String) wholeList.getSelectedValue();
				now = itemCollections.searchItem(listname);
				dpanel.setLayout(new GridLayout(1,2));
				detailInformationPanel.setLayout(new BorderLayout());
				detailInf.setLayout(new GridLayout(5,1,10,10));
				detailInfLabel.setLayout(new GridLayout(5,1,10,10));
				System.out.println("addlistSelection ����Ҹ���");
				if (now instanceof Movie) {
					System.out.println("movie �г� ������� ����");
					String [] mdetailInfList = {"����","����","���","�帣","���","�����⵵","����"};
					for (int i =0;i<7;i++) {
						detailInfLabel.add(new JLabel(mdetailInfList[i]));
					}
					detailInf.add(new JLabel(now.getName()));
					detailInf.add(new JLabel(((Movie) now).getDirector()));
					detailInf.add(new JLabel(((Movie) now).getActor()));
					detailInf.add(new JLabel(((Movie) now).getGenre()));
					detailInf.add(new JLabel(((Movie) now).getGrade()));
					detailInf.add(new JLabel(Integer.toString(now.getOpenYear())+"�⵵"));
					detailInf.add(new JLabel(Integer.toString(now.getStar())+"��"));
	
				}
				else if (now instanceof Book) {
					System.out.println("book panel ������� ����");
					String [] bdetailInfList = {"����","����","���ǻ�","���ǳ⵵","����"};
					for (int i=0;i<5;i++) {
						detailInfLabel.add(new JLabel(bdetailInfList[i]));
					}
					detailInf.add(new JLabel(now.getName()));
					detailInf.add(new JLabel(((Book) now).getAuthors()));
					detailInf.add(new JLabel(((Book) now).getPublisher()));
					detailInf.add(new JLabel(Integer.toString(now.getOpenYear())+"�⵵"));
					detailInf.add(new JLabel(Integer.toString(now.getStar())+"��"));
				}

				summaryArea.setText(now.getSummary());
				commentsArea.setText(now.getComments());
				
				detailInformationPanel.add(detailInfLabel,BorderLayout.WEST);
				detailInformationPanel.add(detailInf,BorderLayout.CENTER);

				}
			}
			
		});
		northSearchPanel.setLayout(new GridLayout());
		northSearchPanel.add(searchComboBox);
		northSearchPanel.add(searchtf);
		String [] starArray = new String[10];
		
		
		searchbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector <Item> tempV = new Vector <Item>();
				
				int searchComboBoxIndex = searchComboBox.getSelectedIndex();
				if (searchComboBoxIndex == 0) {	// �������� �˻��ϱ�
					//Vector <Item> tempV = new Vector<Item>();
					tempV = itemCollections.searchNameItem(searchtf.getText());
					for(int i=0;i<tempV.size();i++) {
						starArray[i]= tempV.get(i).getName();
					}
					starList.setListData(starArray);
				}
				else {	//�������� �˻��ϱ� a
					//Vector <Item> tempV = new Vector<Item>();
					tempV = itemCollections.searchStarItem(searchtf.getText());

					for(int i=0;i<tempV.size();i++) {
						starArray[i] = tempV.get(i).getName();
					}
					starList.setListData(starArray);
	
				}
				
			}
		});
		for (int i=0;i<starArray.length;i++) {
			starArray[i]="";
		}

		northSearchPanel.add(searchbt);
		wSearchPanel.setLayout(new BorderLayout());
		wSearchPanel.add(northSearchPanel,BorderLayout.NORTH);
		wSearchPanel.add(listSearchPanel,BorderLayout.CENTER);
		listSearchPanel.add(starList);
		starList.setFixedCellWidth(250);
		//starList.setFixedCellHeight(700);
		starList.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				starList =new JList();
				index = starList.getSelectedIndex();
				if (index ==-1 ){
					
				}
				else {
				detailInf = new JPanel();
				detailInfLabel = new JPanel();
				//detailInformationPanel = new JPanel();
				//dpanel = new JPanel();
				String listname = (String) starList.getSelectedValue();
				now = itemCollections.searchItem(listname);
				dpanel.setLayout(new GridLayout(1,2));
				detailInformationPanel.setLayout(new BorderLayout());
				detailInf.setLayout(new GridLayout(5,1,10,10));
				detailInfLabel.setLayout(new GridLayout(5,1,10,10));
				System.out.println("addlistSelection ����Ҹ���");
				if (now instanceof Movie) {
					System.out.println("movie �г� ������� ����");
					String [] mdetailInfList = {"����","����","���","�帣","���","�����⵵","����"};
					for (int i =0;i<7;i++) {
						detailInfLabel.add(new JLabel(mdetailInfList[i]));
					}
					detailInf.add(new JLabel(now.getName()));
					detailInf.add(new JLabel(((Movie) now).getDirector()));
					detailInf.add(new JLabel(((Movie) now).getActor()));
					detailInf.add(new JLabel(((Movie) now).getGenre()));
					detailInf.add(new JLabel(((Movie) now).getGrade()));
					detailInf.add(new JLabel(Integer.toString(now.getOpenYear())+"�⵵"));
					detailInf.add(new JLabel(Integer.toString(now.getStar())+"��"));
	
				}
				else if (now instanceof Book) {
					System.out.println("book panel ������� ����");
					String [] bdetailInfList = {"����","����","���ǻ�","���ǳ⵵","����"};
					for (int i=0;i<5;i++) {
						detailInfLabel.add(new JLabel(bdetailInfList[i]));
					}
					detailInf.add(new JLabel(now.getName()));
					detailInf.add(new JLabel(((Book) now).getAuthors()));
					detailInf.add(new JLabel(((Book) now).getPublisher()));
					detailInf.add(new JLabel(Integer.toString(now.getOpenYear())+"�⵵"));
					detailInf.add(new JLabel(Integer.toString(now.getStar())+"��"));
				}

				summaryArea.setText(now.getSummary());
				commentsArea.setText(now.getComments());
				
				detailInformationPanel.add(detailInfLabel,BorderLayout.WEST);
				detailInformationPanel.add(detailInf,BorderLayout.CENTER);
				
				}
			}
		});
		dpanel.add(imgPanel);
		dpanel.add(detailInformationPanel);
		
		wLabel.add(wholeList);
		mLabel.add(movieList);
		bLabel.add(bookList);
		sLabel.add(wSearchPanel);
		
		pane.addTab("��ü",wholeList);
		pane.addTab("��ȭ",movieList);
		pane.addTab("����",bookList);
		pane.addTab("�˻�",wSearchPanel);
		return pane;
	}


	class showConfirmDialog implements ActionListener{	//�����ϱ�
		public void actionPerformed(ActionEvent e) {
			//JOptionPane �˾� ���̾�α� �ޱ� ���� ��ư 
			int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?","���� Ȯ��",JOptionPane.YES_NO_OPTION);	
			if(result == JOptionPane.CLOSED_OPTION) { //����ڰ� ���� ���̿��� ���� ���� ���̾�α� â�� ���� ��� 
				
			}
			else if (result == JOptionPane.YES_OPTION) {	//����ڰ� ���� ������ ��� 
				System.exit(0);
			}
			else {	//����ڰ� �ƴϿ��� ������ ��� 
				
			}
		}
	}
	
	class showMessageDialog implements ActionListener{	//���� ���� ������ִ� �׼� ������ 
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "MyNotes �ý���  v 1.0 �Դϴ�.","Message",JOptionPane.INFORMATION_MESSAGE);
		}
	}
		
	private void createMenu() {
		JMenuBar mb = new JMenuBar();//�޴��� ����
		
		JMenu fileMenu = new JMenu("����");
		JMenu helpMenu = new JMenu("����");
		
		JMenuItem open = new JMenuItem("�ҷ�����");
		open.addActionListener(new ActionListener() {
				private JFileChooser chooser = new JFileChooser();
				/*public ActionListener() {
					chooser = new JFileChooser();
				}*/
				public void actionPerformed(ActionEvent e) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter("�������");
					chooser.setFileFilter(filter);
					int ret = chooser.showOpenDialog(null);
					if(ret != JFileChooser.APPROVE_OPTION) {
						JOptionPane.showInternalMessageDialog(null, "������ �������� �ʾҽ��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
						return;
					}
					filePath = chooser.getSelectedFile().getPath();
					//imageLabel.setIcon(new ImageIcon(filePath));
					choosertf.setText(filePath);
				}
		});
		
		JMenuItem save = new JMenuItem("�����ϱ�");
		save.addActionListener(new ActionListener() {
			private JFileChooser chooser = new JFileChooser();
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("�������");
				chooser.setFileFilter(filter);
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					//JOptionPane.showInternalMessageDialog(null, "������ �������� �ʾҽ��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				filePath = chooser.getSelectedFile().getPath();
				//imageLabel.setIcon(new ImageIcon(filePath));
				choosertf.setText(filePath);
			}
		});
		JMenuItem exit = new JMenuItem("����");
		exit.addActionListener(new showConfirmDialog());
		
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		JMenuItem versionInfo = new JMenuItem("���� ����");
		versionInfo.addActionListener(new showMessageDialog());
		
		helpMenu.add(versionInfo);
		
		mb.add(fileMenu);
		mb.add(helpMenu);
		setJMenuBar(mb);
	}

	
		
	class MyModalDialog extends JDialog {		//�߰� ��ư		
		ButtonGroup group = new ButtonGroup();
		JPanel northPanel = new JPanel();
		JPanel mcenterPanel = new JPanel();
		JPanel bcenterPanel = new JPanel();
		JPanel mcenterPanel1 = new JPanel();
		JPanel mcenterPanel2 = new JPanel();
		JPanel bcenterPanel1 = new JPanel();
		JPanel bcenterPanel2 = new JPanel();
		JPanel msouthPanel = new JPanel();
		JPanel bsouthPanel = new JPanel();
		

		JTextField nametf = new JTextField(20);
		JTextField directortf = new JTextField(20);
		JTextField actortf = new JTextField(20);
		JTextField summarytf = new JTextField(20);
		JTextField commentstf = new JTextField(20);
		
		JTextField authortf = new JTextField(20);
		JTextField publishertf = new JTextField(20);
		
		JRadioButton movieRB= new JRadioButton("Movie",true);
		JRadioButton bookRB = new JRadioButton("Book");
		
		private JButton mOK = new JButton("OK");
		private JButton bOK = new JButton("OK");
		private String[] genreList = {"���","��","��","��"};
		private String[] gradeList = {"��ü" , "12�� �̻�","15�� �̻�","û�ҳ� ���� �Ұ�"};
		private Integer[] openYearListI = {2020,2019,2018,2017,2016,2015,2014,2013,2012,2011};
		private String[] openYearListS = {"2020","2019","2018","2017","2016","2015","2014","2013","2012","2011"};
		private JComboBox <String> openYearCombo = new JComboBox <String>(openYearListS);
		private JComboBox <String> genreCombo = new JComboBox <String>(genreList);
		private JComboBox <String> gradeCombo = new JComboBox <String>(gradeList);

		
		private JButton mfileimport = new JButton("�ҷ�����");
		private JButton bfileimport = new JButton("�ҷ�����");
		private JFileChooser chooser = new JFileChooser();
		private JPanel ch = new JPanel();
		public JSlider starSlider = new JSlider(JSlider.HORIZONTAL,1,10,5);	
		private Border movieBorder = BorderFactory.createTitledBorder("��ȭ ����");
		private Border bookBorder = BorderFactory.createTitledBorder("���� ����");


		public MyModalDialog(JFrame frame, String title) {
			super(frame,title);
			setLayout(new BorderLayout());
			group.add(movieRB);
			group.add(bookRB);
			movieRB.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.DESELECTED) {
							bcenterPanel.setVisible(false);
							dialog.remove(bcenterPanel);
							return;
						}
						if (movieRB.isSelected()) {
							bcenterPanel.setVisible(false);
							dialog.remove(bcenterPanel);
							mcenterPanel.setVisible(true);
							dialog.add(mcenterPanel);
						}
					}
				
			});
			bookRB.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.DESELECTED) {
						mcenterPanel.setVisible(false);
						dialog.remove(mcenterPanel);
						return;
					}
					if (bookRB.isSelected()) {
						mcenterPanel.setVisible(false);
						dialog.remove(mcenterPanel);
						bcenterPanel.setVisible(true);
						dialog.add(bcenterPanel);
					}
				}
			
			});
			
			northPanel.add(movieRB);
			northPanel.add(bookRB);
			add(northPanel,BorderLayout.NORTH);
			
			System.out.println(flag);
			//movie
			//openYearCombo.setPreferredSize(new Dimension(20,5));
			//genreCombo.setPreferredSize(new Dimension(20,5));
			//gradeCombo.setPreferredSize(new Dimension(20,5));
			
			mcenterPanel1.setLayout(new GridLayout(10,1,10,10));	//east panel �󼼺���� �ٰŸ� ������ ��� ���� �г�
			mcenterPanel1.add(new JLabel("����"));
			mcenterPanel1.add(new JLabel("����"));
			mcenterPanel1.add(new JLabel("���"));
			mcenterPanel1.add(new JLabel("�帣"));
			mcenterPanel1.add(new JLabel("���"));
			mcenterPanel1.add(new JLabel("�����⵵"));
			mcenterPanel1.add(new JLabel("������"));
			mcenterPanel1.add(new JLabel("����"));
			mcenterPanel1.add(new JLabel("�ٰŸ�"));
			mcenterPanel1.add(new JLabel("������"));
				
			mcenterPanel2.setLayout(new GridLayout(10,1,10,10));	//east panel �󼼺���� �ٰŸ� ������ ��� ���� �г�
			mcenterPanel2.add(nametf);
			mcenterPanel2.add(directortf);
			mcenterPanel2.add(actortf);
			mcenterPanel2.add(genreCombo);
			mcenterPanel2.add(gradeCombo);
			mcenterPanel2.add(openYearCombo);
			ch.setLayout(new BorderLayout());
			ch.add(choosertf,BorderLayout.CENTER);
			mfileimport.addActionListener(new openActionListener());
			ch.add(mfileimport,BorderLayout.EAST);
			mcenterPanel2.add(ch);
			starSlider.setPaintLabels(true);
			starSlider.setPaintTicks(true);
			starSlider.setPaintTrack(true);
			starSlider.setMajorTickSpacing(1);
			starSlider.setMinorTickSpacing(1);
			mcenterPanel2.add(starSlider);
			mcenterPanel2.add(summarytf);
			mcenterPanel2.add(commentstf);
			
			mOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tempname = nametf.getText();
					String tempdirector = directortf.getText();
					String tempactor = actortf.getText();
					int genreIndex = genreCombo.getSelectedIndex();
					String tempgenre = genreList[genreIndex];
					int gradeIndex = gradeCombo.getSelectedIndex();
					String tempgrade = gradeList[gradeIndex];
					int openYearIndex = openYearCombo.getSelectedIndex();
					int tempopenYear = openYearListI[openYearIndex];
					//ImageIcon img = new ImageIcon
					int tempstar = starSlider.getValue();
					String tempsummary = summarytf.getText();
					String tempcomments = commentstf.getText();
					
					//�̹��� ��� �ʱ�ȭ
					//�̹��� tf �ʱ�ȭ
					nametf.setText("");
					summarytf.setText("");
					starSlider.setValue(5);
					genreCombo.setSelectedIndex(0);
					openYearCombo.setSelectedIndex(0);
					directortf.setText("");				
					publishertf.setText("");
					actortf.setText("");
					gradeCombo.setSelectedIndex(0);
					//imagePath="";
					//�̹��� �߰����ֱ�
					Movie tempMovie = new Movie(tempname, tempstar, tempsummary,
							tempcomments, tempopenYear,tempdirector, 
							tempactor,tempgenre, tempgrade);
					//movieV.add(tempMovie);
					setVisible(false);
					whole[w] = tempname;
					movies[m] = tempname;
					m = m+1;
					w = w+1;
					movieList.setListData(movies);
					wholeList.setListData(whole);
						//wMoviePanel.add(movieList);
						//mLabel.add(wMoviePanel);
					if (whatareyoudoing ==0)itemCollections.addItem(tempMovie);
					else if (whatareyoudoing ==1) itemCollections.editItem(tempname,tempMovie);
					//else if (whatareyoudoing ==2) itemCollections.deleteItem(tempname);
			
					setVisible(false);

					}
				});
			msouthPanel.add(mOK);

			//book
			bcenterPanel1.setLayout(new GridLayout(10,1,10,10));	//east panel �󼼺���� �ٰŸ� ������ ��� ���� �г�
			bcenterPanel1.add(new JLabel("����"));
			bcenterPanel1.add(new JLabel("����"));
			bcenterPanel1.add(new JLabel("���ǻ�"));
			bcenterPanel1.add(new JLabel("���ǳ⵵"));
			bcenterPanel1.add(new JLabel("å�̹���"));
			bcenterPanel1.add(new JLabel("����"));
			bcenterPanel1.add(new JLabel("å�Ұ�"));
			bcenterPanel1.add(new JLabel("������"));
				
				
			bcenterPanel2.setLayout(new GridLayout(10,1,10,10));	//east panel �󼼺���� �ٰŸ� ������ ��� ���� �г�
			bcenterPanel2.add(nametf);
			bcenterPanel2.add(authortf);
			bcenterPanel2.add(publishertf);
			bcenterPanel2.add(openYearCombo);
			ch.setLayout(new BorderLayout(5,5));
			bfileimport.addActionListener(new openActionListener());
			ch.add(choosertf,BorderLayout.CENTER);
			ch.add(bfileimport,BorderLayout.EAST);
			bcenterPanel2.add(ch);
			starSlider.setPaintLabels(true);
			starSlider.setPaintTicks(true);
			starSlider.setPaintTrack(true);
			starSlider.setMajorTickSpacing(1);
			starSlider.setMinorTickSpacing(1);
			bcenterPanel2.add(starSlider);
			bcenterPanel2.add(summarytf);
			bcenterPanel2.add(commentstf);
			bOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tempname = nametf.getText();
					String tempauthors = authortf.getText();
					String temppublisher = publishertf.getText();
					int openYearIndex = openYearCombo.getSelectedIndex();
					int tempopenYear = openYearListI[openYearIndex];
					//�̹���
					int tempstar = starSlider.getValue();
					String tempsummary = summarytf.getText();
					String tempcomments = commentstf.getText();
					
					//�̹��� �ʱ�ȭ
				//�̹��� ��� �ʱ�ȭ
					nametf.setText("");
					summarytf.setText("");
					starSlider.setValue(5);
					openYearCombo.setSelectedIndex(0);
					authortf.setText("");				
					publishertf.setText("");
					commentstf.setText("");
					//�̹����� �Ͽ� �־��ֱ� 
					Book tempBook = new Book(tempname, tempstar,tempsummary,
							tempcomments,tempopenYear,tempauthors,
							temppublisher);
					//bookV.add(tempBook);
					
					whole[w] = tempname;
					books[b] =tempname;
					System.out.println(whole[w]);
					System.out.println(books[b]);
					b=b+1;
					w = w+1;
					
					itemCollections.addItem(tempBook);
					bookList.setListData(books);
					wholeList.setListData(whole);
					setVisible(false);
						
				}
				
			});
			bsouthPanel.add(bOK);
			
			mcenterPanel.setPreferredSize(new Dimension(300,500));	
			mcenterPanel.setLayout(new BorderLayout());
			mcenterPanel.add(mcenterPanel1,BorderLayout.WEST);
			mcenterPanel.add(mcenterPanel2,BorderLayout.CENTER);
			mcenterPanel.add(msouthPanel,BorderLayout.SOUTH);
			mcenterPanel.setBorder(movieBorder);
			
			bcenterPanel.setPreferredSize(new Dimension(300,500));	
			bcenterPanel.setLayout(new BorderLayout());
			bcenterPanel.add(bcenterPanel1,BorderLayout.WEST);
			bcenterPanel.add(bcenterPanel2,BorderLayout.CENTER);
			bcenterPanel.add(bsouthPanel,BorderLayout.SOUTH);
			bcenterPanel.setBorder(bookBorder);
				
			if(flag ==0) add(mcenterPanel,BorderLayout.CENTER);
			else if (flag ==1) add(bcenterPanel,BorderLayout.CENTER);
			setSize(400,700);
			
			}
			
			
			
			
		}

		class openActionListener implements ActionListener{
			private JFileChooser chooser;
			public openActionListener() {
				chooser = new JFileChooser();
			}
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF IMAGES","jpg","gif");
				chooser.setFileFilter(filter);
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showInternalMessageDialog(null, "������ �������� �ʾҽ��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				imagePath = chooser.getSelectedFile().getPath();
				//imageLabel.setIcon(new ImageIcon(filePath));
				choosertf.setText(imagePath);
			}
		}
		
		
	
	public static void main(String[] args) throws NullPointerException, Exception {
		// TODO Auto-generated method stub
		new FinalProject();
	}
}
