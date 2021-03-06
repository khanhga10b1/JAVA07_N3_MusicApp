package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author DangHoang
 */
public class App extends javax.swing.JFrame {

    private final Icon iconPause = new ImageIcon(getClass().getResource("/images/pause.png"));
    private final Icon iconResume = new ImageIcon(getClass().getResource("/images/resume.png"));
    private Thread threadPlay;
    private Thread strackbarThread;
    private Thread threadSongName;
    private String fileName;
    private Player player;
    private int songLength;
    private String songPath;
    private boolean songStatus = true;

    public App() {
        initComponents();
        initComponentsManually();
        initEvents();
    }

    /**
     * i
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTop = new javax.swing.JPanel();
        pnLeftTop = new javax.swing.JPanel();
        lbPlaying = new javax.swing.JLabel();
        PnCenterTop = new javax.swing.JPanel();
        lbSong = new javax.swing.JLabel();
        pnBot = new javax.swing.JPanel();
        pnEastBot = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        pnCenterBot = new javax.swing.JPanel();
        pnTopCenter = new javax.swing.JPanel();
        sdTime = new javax.swing.JSlider();
        lbTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btBack = new javax.swing.JButton();
        btPauseResume = new javax.swing.JButton();
        btNext = new javax.swing.JButton();
        btReplay = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        spListSong = new javax.swing.JScrollPane();
        tbSong = new javax.swing.JTable();
        mnbHeader = new javax.swing.JMenuBar();
        mnbFile = new javax.swing.JMenu();
        mniFile = new javax.swing.JMenuItem();
        mniOpen = new javax.swing.JMenuItem();
        spr1 = new javax.swing.JPopupMenu.Separator();
        mniStart = new javax.swing.JMenuItem();
        mniEnd = new javax.swing.JMenuItem();
        spr2 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnbHelp = new javax.swing.JMenu();
        mniInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTop.setBackground(new java.awt.Color(255, 255, 255));
        pnTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        pnLeftTop.setBackground(new java.awt.Color(0, 0, 0));
        pnLeftTop.setForeground(new java.awt.Color(255, 255, 255));
        pnLeftTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 23));

        lbPlaying.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbPlaying.setForeground(new java.awt.Color(255, 255, 255));
        lbPlaying.setText("ĐANG PHÁT : ");
        pnLeftTop.add(lbPlaying);
        lbPlaying.getAccessibleContext().setAccessibleName("  ĐANG PHÁT : ");

        PnCenterTop.setBackground(new java.awt.Color(204, 0, 51));
        PnCenterTop.setForeground(new java.awt.Color(204, 204, 0));
        PnCenterTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 21));

        lbSong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbSong.setForeground(new java.awt.Color(204, 204, 0));
        PnCenterTop.add(lbSong);

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addComponent(pnLeftTop, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PnCenterTop, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnCenterTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnLeftTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnBot.setLayout(new java.awt.BorderLayout());

        pnEastBot.setPreferredSize(new java.awt.Dimension(194, 120));

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAdd.setText("Thêm bài hát");

        btDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btDelete.setText("Xóa bài hát");

        javax.swing.GroupLayout pnEastBotLayout = new javax.swing.GroupLayout(pnEastBot);
        pnEastBot.setLayout(pnEastBotLayout);
        pnEastBotLayout.setHorizontalGroup(
            pnEastBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEastBotLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(pnEastBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        pnEastBotLayout.setVerticalGroup(
            pnEastBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEastBotLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btAdd)
                .addGap(18, 18, 18)
                .addComponent(btDelete)
                .addGap(24, 24, 24))
        );

        pnBot.add(pnEastBot, java.awt.BorderLayout.EAST);

        pnCenterBot.setPreferredSize(new java.awt.Dimension(628, 120));

        lbTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnTopCenterLayout = new javax.swing.GroupLayout(pnTopCenter);
        pnTopCenter.setLayout(pnTopCenterLayout);
        pnTopCenterLayout.setHorizontalGroup(
            pnTopCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sdTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnTopCenterLayout.setVerticalGroup(
            pnTopCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTopCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sdTime, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btBack.setBorder(null);
        jPanel2.add(btBack);

        btPauseResume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause.png"))); // NOI18N
        btPauseResume.setBorder(null);
        jPanel2.add(btPauseResume);

        btNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        btNext.setBorder(null);
        jPanel2.add(btNext);

        btReplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/replay.png"))); // NOI18N
        btReplay.setBorder(null);
        jPanel2.add(btReplay);

        jButton5.setText("jButton5");
        jPanel2.add(jButton5);

        jButton6.setText("jButton6");
        jPanel2.add(jButton6);

        javax.swing.GroupLayout pnCenterBotLayout = new javax.swing.GroupLayout(pnCenterBot);
        pnCenterBot.setLayout(pnCenterBotLayout);
        pnCenterBotLayout.setHorizontalGroup(
            pnCenterBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
            .addComponent(pnTopCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnCenterBotLayout.setVerticalGroup(
            pnCenterBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterBotLayout.createSequentialGroup()
                .addComponent(pnTopCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnBot.add(pnCenterBot, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnBot, java.awt.BorderLayout.PAGE_END);

        pnCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "hihi", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tbSong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSong.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spListSong.setViewportView(tbSong);

        javax.swing.GroupLayout pnCenterLayout = new javax.swing.GroupLayout(pnCenter);
        pnCenter.setLayout(pnCenterLayout);
        pnCenterLayout.setHorizontalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spListSong, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCenterLayout.setVerticalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spListSong, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        mnbFile.setText("File");

        mniFile.setText("Chọn file");
        mnbFile.add(mniFile);

        mniOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniOpen.setText("Chọn playlist");
        mnbFile.add(mniOpen);
        mnbFile.add(spr1);

        mniStart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniStart.setText("Tạo playlist");
        mnbFile.add(mniStart);

        mniEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniEnd.setText("Xóa playlist");
        mnbFile.add(mniEnd);
        mnbFile.add(spr2);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniExit.setText("Thoát chương trình");
        mnbFile.add(mniExit);

        mnbHeader.add(mnbFile);

        mnbHelp.setText("Help");

        mniInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniInfo.setText("Thông tin");
        mnbHelp.add(mniInfo);

        mnbHeader.add(mnbHelp);

        setJMenuBar(mnbHeader);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnCenterTop;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btBack;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNext;
    private javax.swing.JButton btPauseResume;
    private javax.swing.JButton btReplay;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbPlaying;
    private javax.swing.JLabel lbSong;
    private javax.swing.JLabel lbTime;
    private javax.swing.JMenu mnbFile;
    private javax.swing.JMenuBar mnbHeader;
    private javax.swing.JMenu mnbHelp;
    private javax.swing.JMenuItem mniEnd;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniFile;
    private javax.swing.JMenuItem mniInfo;
    private javax.swing.JMenuItem mniOpen;
    private javax.swing.JMenuItem mniStart;
    private javax.swing.JPanel pnBot;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnCenterBot;
    private javax.swing.JPanel pnEastBot;
    private javax.swing.JPanel pnLeftTop;
    private javax.swing.JPanel pnTop;
    private javax.swing.JPanel pnTopCenter;
    private javax.swing.JSlider sdTime;
    private javax.swing.JScrollPane spListSong;
    private javax.swing.JPopupMenu.Separator spr1;
    private javax.swing.JPopupMenu.Separator spr2;
    private javax.swing.JTable tbSong;
    // End of variables declaration//GEN-END:variables

    private void initComponentsManually() {
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btBack.setBackground(new Color(0, 0, 0, 0));
        sdTime.setValue(0);
    }

    private void initEvents() {

        btNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            }
        });

        mniFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String path = getClass().getResource("/music").getFile();
                JFileChooser fc = new JFileChooser(path);
                int chooser = fc.showDialog(null, "Upload");
                if (chooser == JFileChooser.APPROVE_OPTION) {
                    File sourceFile = fc.getSelectedFile();
                    fileName = sourceFile.getName();

                    String regex = "[\\w-]+[.]{1}(?i)(?:mp3)";
                    if (!(fileName.matches(regex))) {
                        JOptionPane.showMessageDialog(null, "INVALID IMAGE PATH");
                        return;
                    }
                    try {
                        songPath = sourceFile.getCanonicalPath();
                    } catch (IOException ex) {
                    }
                    lbSong.setText(fileName.split(".mp3")[0]);
                    try {
                        getDurationFormat(sourceFile);
                    } catch (Exception ex) {
                    }
                }
            }
        });

        btPauseResume.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (songPath != null) {
                    if (songStatus) {
                        songPlay();
                        btPauseResume.setIcon(iconResume);
                        songStatus = false;
                    } else {
                        btPauseResume.setIcon(iconPause);
                        songStatus = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Can't find song!");
                }
            }
        });

        mniInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Music App - version 1.0 \nMade by: DangHoang-HoangKhanh-HoKhanh");
            }
        });
    }

    @SuppressWarnings("SleepWhileInLoop")
    private void songPlay() {
        threadSongName = new Thread(() -> {
            int i = (PnCenterTop.getWidth() - lbSong.getWidth()) / 2;
            while (true) {
                lbSong.setBounds(i -= 15, 21, lbSong.getWidth(), lbSong.getHeight());
                if (i <= 0) {
                    i = PnCenterTop.getWidth() - lbSong.getWidth();
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                }
            }
        });
        threadSongName.start();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        File f = new File(songPath);
        try {
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            songLength = getDuration(f);
            sdTime.setMaximum(songLength);
        } catch (Exception ex) {
        }
        threadPlay = new Thread(() -> {
            try {
                player.play();
            } catch (JavaLayerException ex) {
            }
        });
        threadPlay.start();
        strackbarThread = new Thread(() -> {
            try {
                int n = 0;
                while (!player.isComplete() && threadPlay.isAlive()) {
                    sdTime.setValue(n++);
                    Thread.sleep(1000);
                }
                sdTime.setValue(songLength);
            } catch (InterruptedException ex) {
            }
        });
        strackbarThread.start();
    }

    private int getDuration(File f) throws Exception {
        int mili = 0;
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(f);
        long microsecond = (long) fileFormat.properties().get("duration");
        mili = (int) (microsecond / 100);
        return mili / 10000;
    }

    private void getDurationFormat(File f) throws Exception {
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(f);
        long microsecond = (long) fileFormat.properties().get("duration");
        long sec = TimeUnit.MICROSECONDS.toSeconds(microsecond) / 10;
        long minute = TimeUnit.MICROSECONDS.toMinutes(microsecond);
        long hour = TimeUnit.MICROSECONDS.toHours(microsecond);
        lbTime.setText(hour + ":" + minute + ":" + sec);
    }
}
