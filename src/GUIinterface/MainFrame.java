// <editor-fold defaultstate="collapsed" desc="Login Module">
package GUIinterface;

import java.awt.Toolkit;
import JDBC.TrackDatabaseConnectivity;
import JDBC.UserDatabaseConnectivity;
import jaco.mp3.player.MP3Player;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

public class MainFrame extends javax.swing.JFrame {

    private final int USER = 0, HOME = 1, SEARCH = 2, PLAYLIST = 3, SETTING = 4;
    private int PANEL = HOME;
    final static MP3Player PLAYER = new MP3Player();
    private int UserID;
    private String playlistName;
    static boolean True = false;
    static ArrayList<Song> queuePlaylist = new ArrayList<>();
    static int playing = -1;
    static String name;

    public void setDetails() {
        this.userBtn.setText("  Guest");
        this.UserPanelLabel.setText("  Guest");
        this.LocationLabel.setText("/Music");
        this.UserID = 1;
        jLabel2.setVisible(false);
        jSeparator8.setVisible(false);
        newPlaylistBtn.setVisible(false);
        listScrollPane.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        changeLocationBtn.setVisible(false);
        jSeparator5.setVisible(false);
        LocationLabel.setVisible(false);
    }

    public void setDetails(String Username, String DownloadLocation, int UserID) {
        this.userBtn.setText(" " + Username);
        this.UserPanelLabel.setText("  " + Username);
        this.LocationLabel.setText(DownloadLocation);
        this.UserID = UserID;

        ResultSet rs = TrackDatabaseConnectivity.runQuery("SELECT * FROM `PlaylistDatabase` WHERE `UserID`=" + UserID);
        DefaultListModel dm = new DefaultListModel();

        try {
            while (rs.next()) {

                dm.addElement(rs.getString("PlaylistName"));
            }
            jList1.setModel(dm);
        } catch (SQLException ex) {

        }
    }

    void playSong(String URL, String Title, String Album) {
        try {
            PLAYER.addToPlayList(new URL(URL));
            PLAYER.skipForward();
            if (PLAYER.isStopped() || PLAYER.isPaused()) {
                playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pause.png")));
                PLAYER.play();
            }
            jLabel3.setText(Title);
            jLabel4.setText(Album);
            TrackDatabaseConnectivity.increaseView(URL);
        } catch (MalformedURLException ex) {
        }
    }

    public MainFrame() {
        initComponents();
        Runnable r = new Runnable1();
        Thread t1 = new Thread(r);
        t1.start();
        
        try {
            this.add(PLAYER);
        } catch (Exception ex) {
        }

    }
    
    class Runnable1 implements Runnable{
        public void run() {
            try {
                Thread.sleep(1000);
                if ((!PLAYER.isPaused()) && True) {
                    Song song = MainFrame.queuePlaylist.get(MainFrame.playing + 1);
                    if (playing + 1 == queuePlaylist.size()) {
                        True = false;
                    }
                    playSong(song.getUrl(), song.getTitle(), song.getAlbum());
                }
            } catch (InterruptedException ex) {
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        DefaultPane = new javax.swing.JPanel();
        homeBtn = new javax.swing.JLabel();
        searchBtn = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JLabel();
        newPlaylistBtn = new javax.swing.JLabel();
        userBtn = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        listScrollPane = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        PlayerPane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        playBtn = new javax.swing.JLabel();
        previousBtn = new javax.swing.JLabel();
        nextBtn = new javax.swing.JLabel();
        shuffleBtn = new javax.swing.JLabel();
        repeatBtn = new javax.swing.JLabel();
        LayeredPane = new javax.swing.JLayeredPane();
        HomePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        SearchPanel = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        searchPanelLabel = new javax.swing.JLabel();
        SearchBar = new javax.swing.JTextField();
        SearchBarBtn = new javax.swing.JLabel();
        SearchBarLabel = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        UserPanel = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        UserPanelLabel = new javax.swing.JLabel();
        SettingPanel = new javax.swing.JPanel();
        settingPanelLabel1 = new javax.swing.JLabel();
        settingsPanelLabel2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        LocationLabel = new javax.swing.JLabel();
        changeLocationBtn = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JLabel();
        PlaylistSongPanel = new javax.swing.JPanel();
        PlaylistName = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        playlistPlay = new javax.swing.JLabel();
        tableScrollPane1 = new javax.swing.JScrollPane();
        playlistTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FLO");
        setBackground(new java.awt.Color(102, 102, 102));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/FloLogo.png")));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1252, 700));
        setMinimumSize(new java.awt.Dimension(1252, 700));
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1252, 670));
        setResizable(false);

        BackgroundPanel.setBackground(new java.awt.Color(51, 51, 51));
        BackgroundPanel.setMaximumSize(new java.awt.Dimension(1252, 665));
        BackgroundPanel.setMinimumSize(new java.awt.Dimension(1252, 665));
        BackgroundPanel.setName(""); // NOI18N
        BackgroundPanel.setPreferredSize(new java.awt.Dimension(1252, 665));
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DefaultPane.setBackground(new java.awt.Color(20, 19, 19));
        DefaultPane.setMaximumSize(new java.awt.Dimension(243, 588));
        DefaultPane.setMinimumSize(new java.awt.Dimension(243, 588));
        DefaultPane.setPreferredSize(new java.awt.Dimension(243, 588));
        DefaultPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeBtn.setBackground(new java.awt.Color(204, 204, 204));
        homeBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(255, 102, 0));
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png"))); // NOI18N
        homeBtn.setText("  Home");
        homeBtn.setAlignmentY(0.0F);
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeBtnMouseExited(evt);
            }
        });
        DefaultPane.add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 196, -1));

        searchBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(153, 153, 153));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.jpg"))); // NOI18N
        searchBtn.setText("  Search");
        searchBtn.setAlignmentY(0.0F);
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBtnMouseExited(evt);
            }
        });
        DefaultPane.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 196, -1));

        settingsBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        settingsBtn.setForeground(new java.awt.Color(153, 153, 153));
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/settings.jpg"))); // NOI18N
        settingsBtn.setText("  Settings");
        settingsBtn.setAlignmentY(0.0F);
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsBtnMouseExited(evt);
            }
        });
        DefaultPane.add(settingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 196, -1));

        newPlaylistBtn.setFont(new java.awt.Font("Leelawadee", 1, 19)); // NOI18N
        newPlaylistBtn.setForeground(new java.awt.Color(153, 153, 153));
        newPlaylistBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/newPlaylist.png"))); // NOI18N
        newPlaylistBtn.setText("  New Playlists");
        newPlaylistBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newPlaylistBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newPlaylistBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newPlaylistBtnMouseExited(evt);
            }
        });
        DefaultPane.add(newPlaylistBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 190, -1));

        userBtn.setFont(new java.awt.Font("Leelawadee", 1, 32)); // NOI18N
        userBtn.setForeground(new java.awt.Color(153, 153, 153));
        userBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/profileSmall.jpg"))); // NOI18N
        userBtn.setText(" Username");
        userBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userBtnMouseExited(evt);
            }
        });
        DefaultPane.add(userBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 219, 54));
        DefaultPane.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 219, 10));

        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Playlists");
        DefaultPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, 30));

        jSeparator9.setForeground(new java.awt.Color(255, 102, 0));
        DefaultPane.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 219, 10));

        listScrollPane.setBorder(null);
        listScrollPane.setOpaque(false);

        jList1.setBackground(new java.awt.Color(20, 19, 19));
        jList1.setFont(new java.awt.Font("Leelawadee", 1, 19)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jList1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        listScrollPane.setViewportView(jList1);

        DefaultPane.add(listScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 419, 200, 110));

        BackgroundPanel.add(DefaultPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        PlayerPane.setBackground(new java.awt.Color(35, 35, 35));
        PlayerPane.setMaximumSize(new java.awt.Dimension(1250, 74));
        PlayerPane.setMinimumSize(new java.awt.Dimension(1250, 74));
        PlayerPane.setName(""); // NOI18N
        PlayerPane.setPreferredSize(new java.awt.Dimension(1250, 74));
        PlayerPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name of song");
        PlayerPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 12, 180, -1));

        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name of Album");
        PlayerPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 43, 180, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/songCoverPhoto.jpg"))); // NOI18N
        PlayerPane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 12, -1, -1));

        playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/play.png"))); // NOI18N
        playBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playBtnMouseClicked(evt);
            }
        });
        PlayerPane.add(playBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        previousBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/previous.png"))); // NOI18N
        previousBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousBtnMouseClicked(evt);
            }
        });
        PlayerPane.add(previousBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/next.png"))); // NOI18N
        nextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextBtnMouseClicked(evt);
            }
        });
        PlayerPane.add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        shuffleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/shuffleOff.png"))); // NOI18N
        shuffleBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shuffleBtnMouseClicked(evt);
            }
        });
        PlayerPane.add(shuffleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 32));

        repeatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/repeatOff.png"))); // NOI18N
        repeatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repeatBtnMouseClicked(evt);
            }
        });
        PlayerPane.add(repeatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, 32));

        BackgroundPanel.add(PlayerPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, -1, -1));

        LayeredPane.setPreferredSize(new java.awt.Dimension(1005, 588));
        LayeredPane.setLayout(new java.awt.CardLayout());

        HomePanel.setBackground(new java.awt.Color(25, 25, 25));
        HomePanel.setForeground(new java.awt.Color(255, 255, 255));
        HomePanel.setMaximumSize(new java.awt.Dimension(1005, 588));
        HomePanel.setMinimumSize(new java.awt.Dimension(1005, 588));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Home");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setMaximumSize(new java.awt.Dimension(50, 10));

        jLabel14.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Editor's Choice");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/playlist1.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/playlist2.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/playlist3.png"))); // NOI18N
        jLabel21.setMaximumSize(new java.awt.Dimension(250, 250));
        jLabel21.setMinimumSize(new java.awt.Dimension(250, 250));
        jLabel21.setPreferredSize(new java.awt.Dimension(250, 250));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Retro Music");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Hip Hop Music");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Trending Now");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(198, 198, 198)
                .addComponent(jLabel23)
                .addGap(139, 139, 139))
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addGroup(HomePanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel14))))
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel18)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel19)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        LayeredPane.add(HomePanel, "card3");

        SearchPanel.setBackground(new java.awt.Color(25, 25, 25));
        SearchPanel.setForeground(new java.awt.Color(25, 25, 25));
        SearchPanel.setMaximumSize(new java.awt.Dimension(1005, 588));
        SearchPanel.setMinimumSize(new java.awt.Dimension(1005, 588));
        SearchPanel.setPreferredSize(new java.awt.Dimension(1005, 588));
        SearchPanel.setVisible(false);
        SearchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setForeground(new java.awt.Color(225, 225, 225));
        jSeparator3.setMaximumSize(new java.awt.Dimension(50, 10));
        jSeparator3.setMinimumSize(new java.awt.Dimension(50, 10));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 10));
        SearchPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 960, -1));

        searchPanelLabel.setFont(new java.awt.Font("Leelawadee", 1, 50)); // NOI18N
        searchPanelLabel.setForeground(new java.awt.Color(204, 204, 204));
        searchPanelLabel.setText("  Search");
        searchPanelLabel.setToolTipText("");
        SearchPanel.add(searchPanelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 37, -1, -1));

        SearchBar.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        SearchBar.setForeground(new java.awt.Color(51, 51, 51));
        SearchBar.setAlignmentX(0.0F);
        SearchBar.setAlignmentY(0.0F);
        SearchBar.setBorder(null);
        SearchBar.setOpaque(false);
        SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchBarKeyPressed(evt);
            }
        });
        SearchPanel.add(SearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 470, 40));

        SearchBarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SearchBarBtn.png"))); // NOI18N
        SearchBarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchBarBtnMouseClicked(evt);
            }
        });
        SearchPanel.add(SearchBarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 30, 40));

        SearchBarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/searchBar.png"))); // NOI18N
        SearchPanel.add(SearchBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, 42));

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(1005, 440));
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(25, 25, 25));
        jPanel3.setMaximumSize(new java.awt.Dimension(1005, 440));
        jPanel3.setMinimumSize(new java.awt.Dimension(1005, 440));

        jLabel15.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Search FLO");

        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Find your favorite songs,Artist and Album.");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/searchPanelIcon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(467, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(469, 469, 469))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanel3, "card4");

        jPanel1.setBackground(new java.awt.Color(25, 25, 25));
        jPanel1.setMaximumSize(new java.awt.Dimension(1005, 440));
        jPanel1.setMinimumSize(new java.awt.Dimension(1005, 440));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("No Result Found");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLabel10)
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel10)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanel1, "card3");

        jPanel2.setBackground(new java.awt.Color(25, 25, 25));
        jPanel2.setMaximumSize(new java.awt.Dimension(1005, 440));
        jPanel2.setMinimumSize(new java.awt.Dimension(1005, 440));

        tableScrollPane.setBackground(new java.awt.Color(25, 25, 25));
        tableScrollPane.setBorder(null);
        tableScrollPane.setForeground(new java.awt.Color(25, 25, 25));
        tableScrollPane.setMaximumSize(new java.awt.Dimension(450, 400));

        searchTable.setBackground(new java.awt.Color(25, 25, 25));
        searchTable.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        searchTable.setForeground(new java.awt.Color(255, 255, 255));
        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchTable.setColumnSelectionAllowed(true);
        searchTable.setFillsViewportHeight(true);
        searchTable.setGridColor(new java.awt.Color(51, 51, 51));
        searchTable.setRowHeight(45);
        searchTable.setSelectionBackground(new java.awt.Color(102, 102, 102));
        searchTable.setShowVerticalLines(false);
        searchTable.getTableHeader().setReorderingAllowed(false);
        searchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTableMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(searchTable);
        searchTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (searchTable.getColumnModel().getColumnCount() > 0) {
            searchTable.getColumnModel().getColumn(0).setResizable(false);
            searchTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            searchTable.getColumnModel().getColumn(1).setResizable(false);
            searchTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            searchTable.getColumnModel().getColumn(2).setResizable(false);
            searchTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            searchTable.getColumnModel().getColumn(3).setResizable(false);
            searchTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            searchTable.getColumnModel().getColumn(4).setResizable(false);
            searchTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchTable.getColumnModel().getColumn(5).setResizable(false);
            searchTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            searchTable.getColumnModel().getColumn(6).setResizable(false);
            searchTable.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        jLabel8.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("TITLE");

        jLabel9.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("ALBUM");

        jLabel12.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("ARTIST");

        jLabel13.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("VIEWS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(132, 132, 132)
                .addComponent(jLabel12)
                .addGap(130, 130, 130)
                .addComponent(jLabel13)
                .addGap(219, 219, 219))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLayeredPane1.add(jPanel2, "card2");

        SearchPanel.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1000, 440));

        LayeredPane.add(SearchPanel, "card4");

        UserPanel.setBackground(new java.awt.Color(25, 25, 25));
        UserPanel.setMaximumSize(new java.awt.Dimension(1005, 588));
        UserPanel.setMinimumSize(new java.awt.Dimension(1005, 588));
        UserPanel.setPreferredSize(new java.awt.Dimension(1005, 588));

        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator6.setMaximumSize(new java.awt.Dimension(50, 10));

        UserPanelLabel.setFont(new java.awt.Font("Leelawadee", 1, 50)); // NOI18N
        UserPanelLabel.setForeground(new java.awt.Color(204, 204, 204));
        UserPanelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/profileBig.jpg"))); // NOI18N
        UserPanelLabel.setText("  Username");

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(UserPanelLabel)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(UserPanelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(386, 386, 386))
        );

        LayeredPane.add(UserPanel, "card2");

        SettingPanel.setBackground(new java.awt.Color(25, 25, 25));
        SettingPanel.setForeground(new java.awt.Color(255, 255, 255));
        SettingPanel.setMaximumSize(new java.awt.Dimension(1005, 588));
        SettingPanel.setMinimumSize(new java.awt.Dimension(1005, 588));
        SettingPanel.setPreferredSize(new java.awt.Dimension(1005, 588));

        settingPanelLabel1.setFont(new java.awt.Font("Leelawadee", 1, 50)); // NOI18N
        settingPanelLabel1.setForeground(new java.awt.Color(255, 255, 255));
        settingPanelLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/settingPanelIcon.png"))); // NOI18N

        settingsPanelLabel2.setFont(new java.awt.Font("Leelawadee", 1, 50)); // NOI18N
        settingsPanelLabel2.setForeground(new java.awt.Color(255, 255, 255));
        settingsPanelLabel2.setText("Settings");

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Offline Songs Storage");

        jLabel6.setFont(new java.awt.Font("Leelawadee", 0, 19)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Location:");

        LocationLabel.setBackground(new java.awt.Color(25, 25, 25));
        LocationLabel.setFont(new java.awt.Font("Leelawadee", 0, 19)); // NOI18N
        LocationLabel.setForeground(new java.awt.Color(153, 153, 153));
        LocationLabel.setAlignmentY(0.0F);
        LocationLabel.setMaximumSize(new java.awt.Dimension(440, 45));
        LocationLabel.setMinimumSize(new java.awt.Dimension(440, 45));
        LocationLabel.setPreferredSize(new java.awt.Dimension(440, 45));

        changeLocationBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        changeLocationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ChangeLocationUnhighlighted.png"))); // NOI18N
        changeLocationBtn.setAlignmentY(0.0F);
        changeLocationBtn.setMaximumSize(new java.awt.Dimension(187, 43));
        changeLocationBtn.setMinimumSize(new java.awt.Dimension(187, 43));
        changeLocationBtn.setPreferredSize(new java.awt.Dimension(187, 43));
        changeLocationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeLocationBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeLocationBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeLocationBtnMouseExited(evt);
            }
        });

        logOutBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LogOutUnhighlighted.png"))); // NOI18N
        logOutBtn.setAlignmentY(0.0F);
        logOutBtn.setMaximumSize(new java.awt.Dimension(241, 57));
        logOutBtn.setMinimumSize(new java.awt.Dimension(241, 57));
        logOutBtn.setPreferredSize(new java.awt.Dimension(241, 57));
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SettingPanelLayout = new javax.swing.GroupLayout(SettingPanel);
        SettingPanel.setLayout(SettingPanelLayout);
        SettingPanelLayout.setHorizontalGroup(
            SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingPanelLayout.createSequentialGroup()
                .addGroup(SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(settingPanelLabel1)
                        .addGroup(SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingPanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(settingsPanelLabel2))
                            .addGroup(SettingPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SettingPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(SettingPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LocationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changeLocationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(SettingPanelLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SettingPanelLayout.setVerticalGroup(
            SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingPanelLayout.createSequentialGroup()
                .addGroup(SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(settingPanelLabel1))
                    .addGroup(SettingPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(settingsPanelLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeLocationBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LocationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        LayeredPane.add(SettingPanel, "card6");

        PlaylistSongPanel.setBackground(new java.awt.Color(25, 25, 25));
        PlaylistSongPanel.setMaximumSize(new java.awt.Dimension(1005, 588));
        PlaylistSongPanel.setMinimumSize(new java.awt.Dimension(1005, 588));

        PlaylistName.setFont(new java.awt.Font("Leelawadee", 1, 50)); // NOI18N
        PlaylistName.setForeground(new java.awt.Color(204, 204, 204));
        PlaylistName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/profileBig.jpg"))); // NOI18N
        PlaylistName.setText("  Name of Playlist");

        jSeparator7.setForeground(new java.awt.Color(225, 225, 225));
        jSeparator7.setMaximumSize(new java.awt.Dimension(50, 10));

        playlistPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/playlistPlay.png"))); // NOI18N
        playlistPlay.setText("jLabel9");
        playlistPlay.setMaximumSize(new java.awt.Dimension(180, 63));
        playlistPlay.setMinimumSize(new java.awt.Dimension(180, 63));
        playlistPlay.setPreferredSize(new java.awt.Dimension(180, 63));
        playlistPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistPlayMouseClicked(evt);
            }
        });

        tableScrollPane1.setBackground(new java.awt.Color(25, 25, 25));
        tableScrollPane1.setBorder(null);
        tableScrollPane1.setForeground(new java.awt.Color(25, 25, 25));
        tableScrollPane1.setMaximumSize(new java.awt.Dimension(450, 400));

        playlistTable.setBackground(new java.awt.Color(25, 25, 25));
        playlistTable.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        playlistTable.setForeground(new java.awt.Color(255, 255, 255));
        playlistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        playlistTable.setColumnSelectionAllowed(true);
        playlistTable.setFillsViewportHeight(true);
        playlistTable.setGridColor(new java.awt.Color(51, 51, 51));
        playlistTable.setRowHeight(45);
        playlistTable.setSelectionBackground(new java.awt.Color(102, 102, 102));
        playlistTable.setShowVerticalLines(false);
        playlistTable.getTableHeader().setReorderingAllowed(false);
        playlistTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistTableMouseClicked(evt);
            }
        });
        tableScrollPane1.setViewportView(playlistTable);
        playlistTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (playlistTable.getColumnModel().getColumnCount() > 0) {
            playlistTable.getColumnModel().getColumn(0).setResizable(false);
            playlistTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            playlistTable.getColumnModel().getColumn(1).setResizable(false);
            playlistTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            playlistTable.getColumnModel().getColumn(2).setResizable(false);
            playlistTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            playlistTable.getColumnModel().getColumn(3).setResizable(false);
            playlistTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            playlistTable.getColumnModel().getColumn(4).setResizable(false);
            playlistTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            playlistTable.getColumnModel().getColumn(5).setResizable(false);
            playlistTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            playlistTable.getColumnModel().getColumn(6).setResizable(false);
            playlistTable.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        jLabel11.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("TITLE");

        jLabel24.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("ALBUM");

        jLabel25.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("ARTIST");

        jLabel26.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("VIEWS");

        javax.swing.GroupLayout PlaylistSongPanelLayout = new javax.swing.GroupLayout(PlaylistSongPanel);
        PlaylistSongPanel.setLayout(PlaylistSongPanelLayout);
        PlaylistSongPanelLayout.setHorizontalGroup(
            PlaylistSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlaylistSongPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(PlaylistName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playlistPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlaylistSongPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(PlaylistSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlaylistSongPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlaylistSongPanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel11)
                .addGap(198, 198, 198)
                .addComponent(jLabel24)
                .addGap(134, 134, 134)
                .addComponent(jLabel25)
                .addGap(128, 128, 128)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PlaylistSongPanelLayout.setVerticalGroup(
            PlaylistSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlaylistSongPanelLayout.createSequentialGroup()
                .addGroup(PlaylistSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlaylistSongPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(PlaylistName))
                    .addGroup(PlaylistSongPanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(playlistPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PlaylistSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        LayeredPane.add(PlaylistSongPanel, "card5");

        BackgroundPanel.add(LayeredPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseEntered
        if (PANEL != HOME) {
            homeBtn.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_homeBtnMouseEntered
    private void homeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseExited
        if (PANEL != HOME) {
            homeBtn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_homeBtnMouseExited
    private void searchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseEntered
        if (PANEL != SEARCH) {
            searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_searchBtnMouseEntered
    private void searchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseExited
        if (PANEL != SEARCH) {
            searchBtn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_searchBtnMouseExited
    private void newPlaylistBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPlaylistBtnMouseEntered
        if (PANEL != PLAYLIST) {
            newPlaylistBtn.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_newPlaylistBtnMouseEntered
    private void newPlaylistBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPlaylistBtnMouseExited
        if (PANEL != PLAYLIST) {
            newPlaylistBtn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_newPlaylistBtnMouseExited
    private void settingsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseEntered
        if (PANEL != SETTING) {
            settingsBtn.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_settingsBtnMouseEntered
    private void settingsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseExited
        if (PANEL != SETTING) {
            settingsBtn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_settingsBtnMouseExited

    private void playBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playBtnMouseClicked
        if (PLAYER.isStopped() || PLAYER.isPaused()) {
            playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pause.png")));
            PLAYER.play();
        } else {
            playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/play.png")));
            PLAYER.pause();
        }
    }//GEN-LAST:event_playBtnMouseClicked
    private void repeatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repeatBtnMouseClicked
        if (PLAYER.isRepeat()) {
            repeatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/repeatOff.png")));
            PLAYER.setRepeat(false);
        } else {
            repeatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/repeatOn.png")));
            PLAYER.setRepeat(true);
        }
    }//GEN-LAST:event_repeatBtnMouseClicked
    private void shuffleBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shuffleBtnMouseClicked
        if (PLAYER.isShuffle()) {
            shuffleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/shuffleOff.png")));
            PLAYER.setShuffle(false);
        } else {
            shuffleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/shuffleOn.png")));
            PLAYER.setShuffle(true);
        }
    }//GEN-LAST:event_shuffleBtnMouseClicked
    private void previousBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousBtnMouseClicked
        PLAYER.skipBackward();
    }//GEN-LAST:event_previousBtnMouseClicked
    private void nextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseClicked
        PLAYER.skipForward();
    }//GEN-LAST:event_nextBtnMouseClicked

    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
        LayeredPane.removeAll();
        LayeredPane.add(HomePanel);
        LayeredPane.repaint();
        LayeredPane.revalidate();

        PANEL = HOME;
        userBtn.setForeground(new java.awt.Color(153, 153, 153));
        homeBtn.setForeground(new java.awt.Color(255, 102, 0));
        searchBtn.setForeground(new java.awt.Color(153, 153, 153));
        newPlaylistBtn.setForeground(new java.awt.Color(153, 153, 153));
        settingsBtn.setForeground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_homeBtnMouseClicked
    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        LayeredPane.removeAll();
        LayeredPane.add(SearchPanel);
        LayeredPane.repaint();
        LayeredPane.revalidate();

        PANEL = SEARCH;
        userBtn.setForeground(new java.awt.Color(153, 153, 153));
        homeBtn.setForeground(new java.awt.Color(153, 153, 153));
        searchBtn.setForeground(new java.awt.Color(255, 102, 0));
        newPlaylistBtn.setForeground(new java.awt.Color(153, 153, 153));
        settingsBtn.setForeground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_searchBtnMouseClicked
    private void newPlaylistBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPlaylistBtnMouseClicked
        new AddPlaylistFrame().setVisible(true);
    }//GEN-LAST:event_newPlaylistBtnMouseClicked
    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseClicked
        LayeredPane.removeAll();
        LayeredPane.add(SettingPanel);
        LayeredPane.repaint();
        LayeredPane.revalidate();

        PANEL = SETTING;
        userBtn.setForeground(new java.awt.Color(153, 153, 153));
        homeBtn.setForeground(new java.awt.Color(153, 153, 153));
        searchBtn.setForeground(new java.awt.Color(153, 153, 153));
        newPlaylistBtn.setForeground(new java.awt.Color(153, 153, 153));
        settingsBtn.setForeground(new java.awt.Color(255, 102, 0));
    }//GEN-LAST:event_settingsBtnMouseClicked

    private void userBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnMouseEntered
        if (PANEL != USER) {
            userBtn.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_userBtnMouseEntered
    private void userBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnMouseExited
        if (PANEL != USER) {
            userBtn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_userBtnMouseExited
    private void userBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnMouseClicked
//        LayeredPane.removeAll();
//        LayeredPane.add(UserPanel);
//        LayeredPane.repaint();
//        LayeredPane.revalidate();
//
//        PANEL = USER;
//        userBtn.setForeground(new java.awt.Color(255, 102, 0));
//        homeBtn.setForeground(new java.awt.Color(153, 153, 153));
//        searchBtn.setForeground(new java.awt.Color(153, 153, 153));
//        newPlaylistBtn.setForeground(new java.awt.Color(153, 153, 153));
//        settingsBtn.setForeground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_userBtnMouseClicked

    private void logOutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseEntered
        logOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LogOutHighlighted.png")));
    }//GEN-LAST:event_logOutBtnMouseEntered
    private void logOutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseExited
        logOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LogOutUnhighlighted.png")));
    }//GEN-LAST:event_logOutBtnMouseExited
    private void logOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseClicked
        new LoginModule().setVisible(true);
        PLAYER.stop();
        this.dispose();
    }//GEN-LAST:event_logOutBtnMouseClicked

    private void changeLocationBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeLocationBtnMouseEntered
        changeLocationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ChangeLocationHighlighted.png")));
    }//GEN-LAST:event_changeLocationBtnMouseEntered
    private void changeLocationBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeLocationBtnMouseExited
        changeLocationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ChangeLocationUnhighlighted.png")));
    }//GEN-LAST:event_changeLocationBtnMouseExited
    private void changeLocationBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeLocationBtnMouseClicked
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setDialogTitle("Select a Folder");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.showOpenDialog(null);
            File f = fileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            UserDatabaseConnectivity.updateDownloadLocation(f, UserID);
            LocationLabel.setText(path);
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_changeLocationBtnMouseClicked

    private void SearchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String title, album, artist;

            DefaultTableModel model = (DefaultTableModel) searchTable.getModel();

            Long view;
            JLabel play = new JLabel();
            play.setIcon(new ImageIcon(getClass().getResource("/Resources/playNow.jpg")));
            JLabel addPlaylist = new JLabel();
            JLabel download = new JLabel();
            if (UserID != 1) {
                download.setIcon(new ImageIcon(getClass().getResource("/Resources/download.jpg")));
                addPlaylist.setIcon(new ImageIcon(getClass().getResource("/Resources/addToPlaylist.jpg")));
            } else {
                download.setIcon(new ImageIcon(getClass().getResource("/Resources/downloadG.jpg")));
                addPlaylist.setIcon(new ImageIcon(getClass().getResource("/Resources/addToPlaylistG.jpg")));
            }

            int rows = model.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            ResultSet rs = TrackDatabaseConnectivity.runQuery("SELECT * FROM `TrackDatabase` WHERE Title LIKE '%" + SearchBar.getText() + "%'");
            try {
                if (rs.next()) {
                    jLayeredPane1.removeAll();
                    jLayeredPane1.add(jPanel2);
                    jLayeredPane1.repaint();
                    jLayeredPane1.revalidate();
                    do {
                        title = rs.getString("Title");
                        album = rs.getString("Album");
                        artist = rs.getString("Artists");
                        view = rs.getLong("Views");
                        model.addRow(new Object[]{play, title, album, artist, view, addPlaylist, download});
                    } while (rs.next());
                    searchTable.getColumnModel().getColumn(0).setCellRenderer(new labelRenderer());
                    searchTable.getColumnModel().getColumn(5).setCellRenderer(new labelRenderer());
                    searchTable.getColumnModel().getColumn(6).setCellRenderer(new labelRenderer());
                } else {
                    jLayeredPane1.removeAll();
                    jLayeredPane1.add(jPanel1);
                    jLayeredPane1.repaint();
                    jLayeredPane1.revalidate();
                }
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_SearchBarKeyPressed
    private void SearchBarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBarBtnMouseClicked

        String title, album, artist;

        DefaultTableModel model = (DefaultTableModel) searchTable.getModel();

        Long view;
        JLabel play = new JLabel();
        play.setIcon(new ImageIcon(getClass().getResource("/Resources/playNow.jpg")));
        JLabel addPlaylist = new JLabel();
        JLabel download = new JLabel();
        if (UserID != 1) {
            download.setIcon(new ImageIcon(getClass().getResource("/Resources/download.jpg")));
            addPlaylist.setIcon(new ImageIcon(getClass().getResource("/Resources/addToPlaylist.jpg")));
        } else {
            download.setIcon(new ImageIcon(getClass().getResource("/Resources/downloadG.jpg")));
            addPlaylist.setIcon(new ImageIcon(getClass().getResource("/Resources/addToPlaylistG.jpg")));
        }

        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        ResultSet rs = TrackDatabaseConnectivity.runQuery("SELECT * FROM `TrackDatabase` WHERE (Title LIKE '%" + SearchBar.getText() + "%') OR Album LIKE '%" + SearchBar.getText() + "%') OR (Artists LIKE '%" + SearchBar.getText() + "%')");
        try {
            if (rs.next()) {
                jLayeredPane1.removeAll();
                jLayeredPane1.add(jPanel2);
                jLayeredPane1.repaint();
                jLayeredPane1.revalidate();
                do {
                    title = rs.getString("Title");
                    album = rs.getString("Album");
                    artist = rs.getString("Artists");
                    view = rs.getLong("Views");
                    model.addRow(new Object[]{play, title, album, artist, view, addPlaylist, download});
                } while (rs.next());
                searchTable.getColumnModel().getColumn(0).setCellRenderer(new labelRenderer());
                searchTable.getColumnModel().getColumn(5).setCellRenderer(new labelRenderer());
                searchTable.getColumnModel().getColumn(6).setCellRenderer(new labelRenderer());
            } else {
                jLayeredPane1.removeAll();
                jLayeredPane1.add(jPanel1);
                jLayeredPane1.repaint();
                jLayeredPane1.revalidate();
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_SearchBarBtnMouseClicked
    private void searchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTableMouseClicked
        int row = searchTable.getSelectedRow();
        int column = searchTable.getSelectedColumn();
        String title = (String) searchTable.getValueAt(row, 1);
        String album = (String) searchTable.getValueAt(row, 2);
        String URL = TrackDatabaseConnectivity.getURL(title, album);
        String artist = (String) searchTable.getValueAt(row, 3);

        switch (column) {
            case 0:
                playSong(URL, title, album);
                queuePlaylist.add(new Song(title, album, URL, artist));
                break;
            case 5:
                if (UserID != 1) {
                    AddSong as = new AddSong();
                    AddSong.title = title;
                    AddSong.Album = album;
                    as.setVisible(true);
                    True = true;
                }
                break;
            case 6:
                if (UserID != 1) {
                    TrackDatabaseConnectivity.downloadTrack(URL);
                }
                break;
            default:
                queuePlaylist.add(new Song(title, album, URL, artist));
                True = true;
                break;
        }
    }//GEN-LAST:event_searchTableMouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        jLabel20MouseClicked(evt);
    }//GEN-LAST:event_jLabel18MouseClicked
    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        jLabel22MouseClicked(evt);
    }//GEN-LAST:event_jLabel19MouseClicked
    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        jLabel23MouseClicked(evt);
    }//GEN-LAST:event_jLabel21MouseClicked
    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        setPlaylistPnl(jLabel20.getText(), 1);
    }//GEN-LAST:event_jLabel20MouseClicked
    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        setPlaylistPnl(jLabel22.getText(), 1);
    }//GEN-LAST:event_jLabel22MouseClicked
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        homeBtn.setForeground(new java.awt.Color(153, 153, 153));
        LayeredPane.removeAll();
        LayeredPane.add(PlaylistSongPanel);
        LayeredPane.repaint();
        LayeredPane.revalidate();
        PANEL = PLAYLIST;
        PlaylistName.setText(jLabel23.getText());
        PlaylistName.setIcon(ResizeImage(new ImageIcon(getClass().getResource("/Resources/playlist3.png"))));

        String title, album, artist;
        Long view;
        JLabel play = new JLabel();
        play.setIcon(new ImageIcon(getClass().getResource("/Resources/playNow.jpg")));
        JLabel addPlaylist = new JLabel();
        JLabel download = new JLabel();
        if (UserID != 1) {
            download.setIcon(new ImageIcon(getClass().getResource("/Resources/download.jpg")));
            addPlaylist.setIcon(new ImageIcon(getClass().getResource("/Resources/addToPlaylist.jpg")));
        } else {
            download.setIcon(new ImageIcon(getClass().getResource("/Resources/downloadG.jpg")));
            addPlaylist.setIcon(new ImageIcon(getClass().getResource("/Resources/addToPlaylistG.jpg")));
        }

        DefaultTableModel model = (DefaultTableModel) playlistTable.getModel();

        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        ResultSet rs = TrackDatabaseConnectivity.runQuery("SELECT * FROM `TrackDatabase` ORDER BY Views DESC");
        int count = 0;
        try {
            while (rs.next() && count++ < 10) {
                title = rs.getString("Title");
                album = rs.getString("Album");
                artist = rs.getString("Artists");
                view = rs.getLong("Views");
                model.addRow(new Object[]{play, title, album, artist, view, addPlaylist, download});
            }
            playlistTable.getColumnModel().getColumn(0).setCellRenderer(new labelRenderer());
            playlistTable.getColumnModel().getColumn(5).setCellRenderer(new labelRenderer());
            playlistTable.getColumnModel().getColumn(6).setCellRenderer(new labelRenderer());

        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jLabel23MouseClicked

    private void playlistPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistPlayMouseClicked
        PLAYER.removeAll();
        String title;
        String album;
        String artist;
        String URL;
        for (int i = 0; i < playlistTable.getRowCount(); i++) {
            title = (String) playlistTable.getValueAt(i, 1);
            album = (String) playlistTable.getValueAt(i, 2);
            artist = (String) playlistTable.getValueAt(i, 3);
            URL = TrackDatabaseConnectivity.getURL(title, album);
            try {
                PLAYER.addToPlayList(new URL(URL));
                queuePlaylist.add(new Song(title, album, URL, artist));
            } catch (MalformedURLException ex) {
            }
        }
        PLAYER.play();
    }//GEN-LAST:event_playlistPlayMouseClicked
    private void playlistTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistTableMouseClicked
        int row = playlistTable.getSelectedRow();
        int column = playlistTable.getSelectedColumn();
        String title = (String) playlistTable.getValueAt(row, 1);
        String album = (String) playlistTable.getValueAt(row, 2);
        String URL = TrackDatabaseConnectivity.getURL(title, album);
        String artist = (String) playlistTable.getValueAt(row, 3);

        switch (column) {
            case 0:
                playSong(URL, title, album);
                True = true;
                queuePlaylist.add(new Song(title, album, URL, artist));
                break;
            case 5:
                if (UserID != 1) {
                    AddSong as = new AddSong();
                    AddSong.title = title;
                    AddSong.Album = album;
                    as.setVisible(true);
                }
                break;
            case 6:
                if (UserID != 1) {
                    TrackDatabaseConnectivity.downloadTrack(URL);
                }
                break;
            default:
                queuePlaylist.add(new Song(title, album, URL, artist));
                True = true;
                break;
        }
    }//GEN-LAST:event_playlistTableMouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        setPlaylistPnl(jList1.getSelectedValue(), UserID);
    }//GEN-LAST:event_jList1MouseClicked

    class labelRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }

    public ImageIcon ResizeImage(ImageIcon MyImage) {
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    // Sets the look of Playlist Panel
    private void setPlaylistPnl(String name, int id) {
        playlistName = name;

        homeBtn.setForeground(new java.awt.Color(153, 153, 153));
        LayeredPane.removeAll();
        LayeredPane.add(PlaylistSongPanel);
        LayeredPane.repaint();
        LayeredPane.revalidate();
        PANEL = PLAYLIST;
        PlaylistName.setText("  " + playlistName);

        try {
            java.sql.Blob blob;
            ResultSet rs = TrackDatabaseConnectivity.runQuery("SELECT `Image` FROM `PlaylistDatabase` WHERE PlaylistName ='" + name + "' AND UserID = " + id);
            rs.next();
            blob = rs.getBlob("Image");
            InputStream in = blob.getBinaryStream();
            BufferedImage image = ImageIO.read(in);
            PlaylistName.setIcon(ResizeImage(new ImageIcon(image)));
        } catch (SQLException | IOException ex) {
        }

        String title, album, artist;
        Long view;
        JLabel play = new JLabel();
        play.setIcon(new ImageIcon(getClass().getResource("/Resources/playNow.jpg")));
        JLabel addPlaylist = new JLabel();
        JLabel download = new JLabel();
        if (UserID != 1) {
            download.setIcon(new ImageIcon(getClass().getResource("/Resources/download.jpg")));
            addPlaylist.setIcon(new ImageIcon(getClass().getResource("/Resources/addToPlaylist.jpg")));
        } else {
            download.setIcon(new ImageIcon(getClass().getResource("/Resources/downloadG.jpg")));
            addPlaylist.setIcon(new ImageIcon(getClass().getResource("/Resources/addToPlaylistG.jpg")));
        }

        DefaultTableModel model = (DefaultTableModel) playlistTable.getModel();

        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        ResultSet rs = TrackDatabaseConnectivity.runQuery("SELECT `TrackDatabase`.`TrackID`, `TrackDatabase`.`Title`, `TrackDatabase`.`Album`, `TrackDatabase`.`Artists`, `TrackDatabase`.`URL`, `TrackDatabase`.`Views` FROM `TrackPlaylistUser` INNER JOIN `TrackDatabase` ON `TrackDatabase`.TrackID = `TrackPlaylistUser`.TrackID INNER JOIN `PlaylistDatabase` ON `TrackPlaylistUser`.PlaylistID = `PlaylistDatabase`.PlaylistID WHERE `PlaylistDatabase`.PlaylistName = '" + playlistName + "' AND `PlaylistDatabase`.UserID = " + id);
        try {
            while (rs.next()) {
                title = rs.getString("Title");
                album = rs.getString("Album");
                artist = rs.getString("Artists");
                view = rs.getLong("Views");
                model.addRow(new Object[]{play, title, album, artist, view, addPlaylist, download});
            }
            playlistTable.getColumnModel().getColumn(0).setCellRenderer(new labelRenderer());
            playlistTable.getColumnModel().getColumn(5).setCellRenderer(new labelRenderer());
            playlistTable.getColumnModel().getColumn(6).setCellRenderer(new labelRenderer());

        } catch (SQLException ex) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JPanel DefaultPane;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JLayeredPane LayeredPane;
    private javax.swing.JLabel LocationLabel;
    private javax.swing.JPanel PlayerPane;
    private javax.swing.JLabel PlaylistName;
    private javax.swing.JPanel PlaylistSongPanel;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JLabel SearchBarBtn;
    private javax.swing.JLabel SearchBarLabel;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JPanel SettingPanel;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JLabel UserPanelLabel;
    private javax.swing.JLabel changeLocationBtn;
    private javax.swing.JLabel homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    public static javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JScrollPane listScrollPane;
    private javax.swing.JLabel logOutBtn;
    private javax.swing.JLabel newPlaylistBtn;
    private javax.swing.JLabel nextBtn;
    private static javax.swing.JLabel playBtn;
    private javax.swing.JLabel playlistPlay;
    private javax.swing.JTable playlistTable;
    private javax.swing.JLabel previousBtn;
    private javax.swing.JLabel repeatBtn;
    private javax.swing.JLabel searchBtn;
    private javax.swing.JLabel searchPanelLabel;
    private javax.swing.JTable searchTable;
    private javax.swing.JLabel settingPanelLabel1;
    private javax.swing.JLabel settingsBtn;
    private javax.swing.JLabel settingsPanelLabel2;
    private javax.swing.JLabel shuffleBtn;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JScrollPane tableScrollPane1;
    private javax.swing.JLabel userBtn;
    // End of variables declaration//GEN-END:variables
}

class Song {

    private String Title;
    private String Album;
    private String Url;
    private String Artist;

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String Album) {
        this.Album = Album;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public Song(String Title, String Album, String Url, String Artist) {
        this.Title = Title;
        this.Album = Album;
        this.Url = Url;
        this.Artist = Artist;
    }
}

//class refresh implements Runnable {
//
//    Thread t;
//
//    public refresh() {
//        t = new Thread();
//        t.start();
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(1000);
//                if ((!PLAYER.isPaused()) && True) {
//                    Song song = MainFrame.queuePlaylist.get(MainFrame.playing + 1);
//                    if (playing + 1 == queuePlaylist.size()) {
//                        True = false;
//                    }
//                    playSong(song.getUrl(), song.getTitle(), song.getAlbum());
//                }
//            } catch (InterruptedException ex) {
//            }
//        }
//    }
//}
