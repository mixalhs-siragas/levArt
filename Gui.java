import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Gui{
    Arc r1 = new Arc("reservations.txt");
    Arc r2 = new Arc("last_res.txt");
    Arc r3 = new Arc("hotel.dat");
    String name, str;
    int date, days, persons, choice, re_number, room_number;
    Hotel h1 = new Hotel("Patra's Palace");
    /*
    Standard_Room a1 = new Standard_Room(90.0, 3, 30.0);
    Standard_Room a2 = new Standard_Room(160.0, 4, 40.0); 
    Discount_Room b1 = new Discount_Room(10, 100.0, 4, 25.0);
    Discount_Room b2 = new Discount_Room(12, 140.0, 4, 23.0);
    Special_Room c1 = new Special_Room(2, 4, 3, 30.0);
    Special_Room c2 = new Special_Room(1, 2, 2, 20.0);
    Luxury_Room d1 = new Luxury_Room(2, 30.0, 60.0, "lunch");
    Luxury_Room d2 = new Luxury_Room(3, 40.0, 120.0, "full meal");
    Smoking_Room e1 = new Smoking_Room(4, 25.0, true);
    Smoking_Room e2 = new Smoking_Room(2, 15.0, false);
    */
    
    public void go(){
        /*
        h1.addRoom(a1);
        h1.addRoom(a2);
        h1.addRoom(b1);
        h1.addRoom(b2);
        h1.addRoom(c1);
        h1.addRoom(c2);
        h1.addRoom(d1);
        h1.addRoom(d2);
        h1.addRoom(e1);
        h1.addRoom(e2);
        */
        
        h1 = r3.load();
        JFrame jf = new JFrame("Hotel");
        JPanel p = new JPanel();
        Icon love = new ImageIcon("index.jpg");
        JLabel label2 = new JLabel();
        label2.setText("Welcome to our hotel!");
        label2.setIcon(love);
        label2.setIconTextGap(50);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setVerticalTextPosition(SwingConstants.TOP);
        p.add(label2);
        jf.add(p,BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(700, 700);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.pack();
        int option = JOptionPane.showConfirmDialog(jf, "Do you want to continue??", "Choose", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
                jf.dispose();
                Icon icon = new ImageIcon("3.jpg");
                Icon icon1 = new ImageIcon("4.jpg");
                JLabel lel = new JLabel();
                JLabel lel1 = new JLabel();
                JFrame jf1 = new JFrame("Patra's Palace");
                JPanel jp = new JPanel();
                JPanel jp1 = new JPanel();
                lel1.setIcon(icon1);
                lel.setIcon(icon);
                JButton b1 = new JButton("Book");
                JButton b2 = new JButton("Edit");
                JButton b3 = new JButton("Cancelation");
                JButton b4 = new JButton("Reservations");
                JButton b5 = new JButton("Invoice");
                JButton b6 = new JButton("Reservations table");
                JButton b7 = new JButton("Exit");
                b1.addActionListener((ActionEvent e) ->{
                    name = JOptionPane.showInputDialog("What's your name?");
                    do{
                        str = JOptionPane.showInputDialog("Type your arrival date: ");
                        date = Integer.parseInt(str);
                    }while(date < 1 || date > 30);
                    do{
                        str = JOptionPane.showInputDialog("Type the days you wish to stay in our hotel: ");
                        days = Integer.parseInt(str);
                    }while(days <= 0 || (days + date - 1) > 30);  
                    do{
                        str = JOptionPane.showInputDialog("Type the room capacity you wish: ");
                        persons = Integer.parseInt(str);
                    }while(persons <1 || persons > 4);
                    Reservation res = new Reservation(name ,date, days, persons);
                    r1.arc(res.re_number);
                    r2.arc1(res.re_number);
                    str = JOptionPane.showInputDialog("If you want to randomly make the reservation press (1)\nIf you want to choose which room you want press (2)");
                    choice = Integer.parseInt(str);
                    if(choice == 1){
                        for(Room room : h1.rooms){    
                            h1.addRes(res);
                            break;
                        }
                    }
                    else if( choice == 2){
                        str = JOptionPane.showInputDialog("Which room you wish to stay to?");
                        room_number = Integer.parseInt(str);
                        for(Room room : h1.rooms){
                             h1.attachResToRoom(room_number, res);
                             break;
                        }
                    }
                    else{JOptionPane.showMessageDialog(null,"You entered invalid data","Error", JOptionPane.PLAIN_MESSAGE);}
                });
                b2.addActionListener((ActionEvent e) ->{
                    str = JOptionPane.showInputDialog("Please type your reservation number: ");
                    re_number = Integer.parseInt(str);
                    h1.resCancelation(re_number);
                    name = JOptionPane.showInputDialog("Retype your name?");
                    do{
                        str = JOptionPane.showInputDialog("Type your new arrival date: ");
                        date = Integer.parseInt(str);
                    }while(date < 1 || date > 30);
                    do{
                        str = JOptionPane.showInputDialog("Type the days you wish to stay in our hotel, once again: ");
                        days = Integer.parseInt(str);
                    }while(days <= 0 || (days + date - 1) > 30);  
                    do{
                        str = JOptionPane.showInputDialog("Type the room capacity you wish, once again: ");
                        persons = Integer.parseInt(str);
                    }while(persons <1 || persons > 4);
                    Reservation res = new Reservation(name ,date, days, persons);
                    r1.arc(res.re_number);
                    r2.arc1(res.re_number);
                    str = JOptionPane.showInputDialog("If you want to randomly make the reservation press (1)\nIf you want to choose which room you want press (2)");
                    choice = Integer.parseInt(str);
                    if(choice == 1){
                        for(Room room : h1.rooms){    
                            h1.addRes(res);
                            break;
                        }
                    }
                    else if( choice == 2){
                        str = JOptionPane.showInputDialog("Which room you wish to stay to?");
                        room_number = Integer.parseInt(str);
                        for(Room room : h1.rooms){
                             h1.attachResToRoom(room_number, res);
                             break;
                        }
                    }
                    else{JOptionPane.showMessageDialog(null,"You entered invalid data", "Error", JOptionPane.PLAIN_MESSAGE);}
                });
                b3.addActionListener((ActionEvent e) ->{
                    str = JOptionPane.showInputDialog("Please type your reservation number: ");
                    re_number = Integer.parseInt(str);
                    h1.resCancelation(re_number);
                });
                b4.addActionListener((ActionEvent e) -> {
                    Reservation[] res = new Reservation[h1.reservations.size()];
                    res = h1.reservations.toArray(res);
                    String[] typeOfInfo = new String[1];
                    typeOfInfo[0] = "Reservations info";
                    String[][] info = new String[res.length][typeOfInfo.length];
                    for(int i = 0; i < res.length; i++){
                        if(res[i] != null){info[i][0] = res[i].printRes();}
                    }
                    JTable infoView = new JTable(info, typeOfInfo);
                    JFrame in = new JFrame("Info");
                    JScrollPane scroller = new JScrollPane(infoView);
                    in.add(scroller);
                    in.setVisible(true);
                    in.setLocationRelativeTo(null);
                    in.setSize(700, 200);
                    in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });
                b5.addActionListener((ActionEvent e) ->{ 
                    str = JOptionPane.showInputDialog("If you want to see the invoice for all rooms press (1)\nIf you want to see the invoice of a particular room press (2)");
                    choice = Integer.parseInt(str);
                    switch(choice){
                        case 1:
                         h1.incomes();
                         break;
                        case 2:
                         do{
                             str = JOptionPane.showInputDialog("Enter the room number: ");
                             room_number = Integer.parseInt(str);
                         }while(room_number > 99 && room_number <= h1.rooms.size()); 
                         h1.incomes(room_number);
                         break;
                    }
                });
                b6.addActionListener((ActionEvent e) ->{
                   h1.roomsView();
                   Room[] room = new Room[h1.rooms.size()];
                   room = h1.rooms.toArray(room);
                   String[] typeOfInfo = new String[1];
                   typeOfInfo[0] = "Rooms info";
                   String[][] info = new String[room.length][typeOfInfo.length];
                   for(int i = 0; i < room.length; i++){
                       if(room[i] != null){info[i][0] = "Room " + room[i].room_number + " occupied for " + room[i].Occupancy() + " %days of the month, and has total incomes " + room[i].Payment(room[i].room_number) + "." ;}
                   }
                   JTable infoView = new JTable(info, typeOfInfo);
                   JFrame in = new JFrame("Info");
                   JScrollPane poutsa = new JScrollPane(infoView);
                   in.add(poutsa, BorderLayout.SOUTH);
                   in.setVisible(true);
                   in.setLocationRelativeTo(null);
                   in.setSize(700, 200);
                   in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });
                b7.addActionListener((ActionEvent e) ->{
                    r3.save(h1);
                    JOptionPane.showMessageDialog(null,"See you later!","Goodbye",JOptionPane.PLAIN_MESSAGE);
                    jf1.dispose();
                });
                jp.add(b1);
                jp.add(b2);
                jp.add(b3);
                jp.add(b4);
                jp.add(b5);
                jp.add(b6);
                jp.add(b7);
                jp1.add(lel1, BorderLayout.EAST);
                jp1.add(lel, BorderLayout.WEST);
                jf1.add(jp1,BorderLayout.NORTH);
                jf1.add(jp,BorderLayout.SOUTH);
                jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf1.setSize(700, 700);
                jf1.setLocationRelativeTo(null);
                jf1.setVisible(true);
                jf1.pack();
        }
        else if(option == JOptionPane.NO_OPTION){JOptionPane.showMessageDialog(null,"Goodbye then :(", "Goodbye", JOptionPane.PLAIN_MESSAGE); jf.dispose();}
    }
}

        