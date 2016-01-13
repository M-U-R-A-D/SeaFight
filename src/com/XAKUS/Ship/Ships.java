package com.XAKUS.Ship;

import com.XAKUS.Game.Coordinate;
import com.XAKUS.Sea.Sea;
import com.XAKUS.Sea.SeaResolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xakus on 23.11.2015.
 */
public class Ships {
      private static int ship4palub, ship3palub, ship2palub, ship1palub;
      private static List<Ship>    myShips;
      private static List<Ship>    compShips;
      private static SeaResolution seaResolution;

      private Ships(SeaResolution seaResolution) {

            switch(seaResolution) {
                  case R_5X5:
                        ship4palub = 0;
                        ship3palub = 0;
                        ship2palub = 1;
                        ship1palub = 3;
                        break;
                  case R_10X10:

                        ship4palub = 1;
                        ship3palub = 2;
                        ship2palub = 3;
                        ship1palub = 4;
                        break;
                  case R_15X15:

                        ship4palub = 3;
                        ship3palub = 4;
                        ship2palub = 5;
                        ship1palub = 6;
                        break;
            }
            myShips = new ArrayList<Ship>();
            compShips = new ArrayList<Ship>();
      }

      public static int getShip4palub() {
            return ship4palub;
      }

      public static int getShip3palub() {
            return ship3palub;
      }

      public static int getShip2palub() {
            return ship2palub;
      }

      public static int getShip1palub() {
            return ship1palub;
      }

      public static List<Ship> getMyShips() {
            return myShips;
      }

      public static List<Ship> getCompShips() {
            return compShips;
      }

      public static void createShips(SeaResolution resolution) {
            Ships.seaResolution = resolution;
            new Ships(resolution);
            for(int i = 0; i < ship4palub; i++) {

                  Ship s = new Ship(4);
                  s.setDeck(fieldGeneration(Sea.myMatrix, 4));
                  myShips.add(s);

                  Ship s2 = new Ship(4);
                  s2.setDeck(fieldGeneration(Sea.compMatrix, 4));
                  compShips.add(s2);

            }
            for(int i = 0; i < ship3palub; i++) {

                  Ship s = new Ship(3);
                  s.setDeck(fieldGeneration(Sea.myMatrix, 3));
                  myShips.add(s);

                  Ship s2 = new Ship(3);
                  s2.setDeck(fieldGeneration(Sea.compMatrix, 3));
                  compShips.add(s2);
            }
            for(int i = 0; i < ship2palub; i++) {

                  Ship s = new Ship(2);
                  s.setDeck(fieldGeneration(Sea.myMatrix, 2));
                  myShips.add(s);

                  Ship s2 = new Ship(2);
                  s2.setDeck(fieldGeneration(Sea.compMatrix, 2));
                  compShips.add(s2);
            }
            for(int i = 0; i < ship1palub; i++) {

                  Ship s = new Ship(1);
                  s.setDeck(fieldGeneration(Sea.myMatrix, 1));
                  myShips.add(s);

                  Ship s2 = new Ship(1);
                  s2.setDeck(fieldGeneration(Sea.compMatrix, 1));
                  compShips.add(s2);
            }
      }

      private static Coordinate fieldGeneration(int[][] seaMartix, int palubaCount) {
            int     x          = 0;
            int     y          = 0;
            int     vh         = 0;
            int[][] virtualSea = null;
            boolean                isOK        = true;
            Coordinate             coordinate  = new Coordinate(0, 0, Coordinate.Positioning.HORIZONTAL);
            Coordinate.Positioning positioning = null;
            while(isOK) {
                  isOK = false;
                  if(seaResolution == SeaResolution.R_5X5) {
                        virtualSea = new int[5][5];
                        vh = new Random().nextInt(2);
                        if(vh == 0) {
                              x = new Random().nextInt(5);
                              y = new Random().nextInt(5 - palubaCount);
                              positioning = Coordinate.Positioning.VERTICAL;
                        } else {
                              x = new Random().nextInt(5 - palubaCount);
                              y = new Random().nextInt(5);
                              positioning = Coordinate.Positioning.HORIZONTAL;
                        }

                  }
                  if(seaResolution == SeaResolution.R_10X10) {
                        virtualSea = new int[10][10];
                        vh = new Random().nextInt(2);
                        if(vh == 0) {
                              x = new Random().nextInt(10);
                              y = new Random().nextInt(10 - palubaCount);
                              positioning = Coordinate.Positioning.VERTICAL;
                        } else {
                              x = new Random().nextInt(10 - palubaCount);
                              y = new Random().nextInt(10);
                              positioning = Coordinate.Positioning.HORIZONTAL;
                        }

                  }
                  if(seaResolution == SeaResolution.R_15X15) {
                        virtualSea = new int[15][15];
                        vh = new Random().nextInt(2);
                        if(vh == 0) {
                              x = new Random().nextInt(15);
                              y = new Random().nextInt(15 - palubaCount);
                              positioning = Coordinate.Positioning.VERTICAL;
                        } else {
                              x = new Random().nextInt(15 - palubaCount);
                              y = new Random().nextInt(15);
                              positioning = Coordinate.Positioning.HORIZONTAL;
                        }

                  }
                  coordinate.setX(x);
                  coordinate.setY(y);
                  coordinate.setPositioning(positioning);
                  for(int z = 0; z < palubaCount; z++) {

                        if(seaMartix[y][x] != 0) {
                              isOK = true;
                              break;
                        }
                        if(y != 0) {
                              if(seaMartix[y - 1][x] != 0) {
                                    isOK = true;
                                    break;
                              }
                        }
                        if(y != seaMartix.length - 1) {
                              if(seaMartix[y + 1][x] != 0) {
                                    isOK = true;
                                    break;
                              }
                        }

                        if(x != 0) {
                              if(seaMartix[y][x - 1] != 0) {
                                    isOK = true;
                                    break;
                              }
                        }
                        if(x != seaMartix[0].length - 1) {
                              if(seaMartix[y][x + 1] != 0) {
                                    isOK = true;
                                    break;
                              }
                        }

                        if(y != 0 && x != 0) {
                              if(seaMartix[y - 1][x - 1] != 0) {
                                    isOK = true;
                                    break;
                              }
                        }
                        if(y != seaMartix.length - 1 && x != seaMartix[0].length - 1) {
                              if(seaMartix[y + 1][x + 1] != 0) {
                                    isOK = true;
                                    break;
                              }
                        }

                        if(y != seaMartix.length - 1 && x != 0) {
                              if(seaMartix[y + 1][x - 1] != 0) {
                                    isOK = true;
                                    break;
                              }
                        }
                        if(y != 0 && x != seaMartix[0].length - 1) {
                              if(seaMartix[y - 1][x + 1] != 0) {
                                    isOK = true;
                                    break;
                              }
                        }
                        if(isOK == false) {
                              virtualSea[x][y] = 1;
                        }
                        if(positioning == Coordinate.Positioning.VERTICAL) {
                              y++;
                        } else {
                              x++;
                        }
                  }
            }
            for(int a = 0; a < virtualSea.length; a++) {
                  for(int b = 0; b < virtualSea[a].length; b++) {

                        if(virtualSea[a][b] == 1) {
                              seaMartix[b][a] = 4;
                        }
                  }
            }
            return coordinate;
      }

}
