public class Calculate {
    String line;
    public Calculate(String nextLine) {
        this.line = nextLine;
        if (nextLine.length() == 0) {
            System.out.println("Ошибка №4: Пустая строка");
            System.exit(0);
        }
    }
    public String calculation() {
        this.line = this.line + " ";
        int sign = -1;
        int a = -1;
        int b = -1;
        int aR = 0;
        int bR = 0;
        String result = "";
        boolean arb = true;
        for (int i = 0; line.length()-1 >= i; i++) {
            switch (line.codePointAt(i)) {
                case 32:
                    break;
                case 43:
                    sign = 1;
                    break;
                case 45:
                    sign = 2;
                    break;
                case 42:
                    sign = 3;
                    break;
                case 47:
                    sign = 4;
                    break;
                case 46:
                    System.out.println("Ошибка №2: Невозможно взаимодействие с дробными числами");
                    System.exit(0);
                case 73:
                case 105:
                    if (line.charAt(i + 1) == 'V' || line.charAt(i + 1) == 'v') {
                        if (sign < 0) {
                            aR = 4;
                        } else {
                            bR = 4;
                        }
                    } else if (line.charAt(i + 1) == 'X' || line.charAt(i + 1) == 'x') {
                        if (sign < 0) {
                            aR = 9;
                        } else {
                            bR = 9;
                        }
                    } else if (sign < 0) {
                        aR = aR + 1;
                    } else {
                        bR = bR + 1;
                    }
                    break;
                case 86:
                case 118:
                    if (sign < 0) {
                        if (aR == 0) {
                            aR = aR + 5;
                        }
                    } else {
                        if (bR == 0) {
                            bR = bR + 5;
                        }
                    }
                    break;
                case 88:
                case 120:
                    if (sign < 0) {
                        if (aR == 0) {
                            aR = aR + 10;
                        }
                    } else {
                        if (bR == 0) {
                            bR = bR + 10;
                        }
                    }
                    break;
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57: {
                    if (sign < 0) {
                        if (a < 0) {
                            a = Character.getNumericValue(line.charAt(i));
                        } else {
                            a = a * 10 + Character.getNumericValue(line.charAt(i));
                        }
                    } else {
                        if (b < 0) {
                            b = Character.getNumericValue(line.charAt(i));
                        } else {
                            b = b * 10 + Character.getNumericValue(line.charAt(i));
                        }
                    }
                }
                break;
                default:
                    System.out.println("Ошибка №4: Недопустимые символы");
                    System.exit(0);
            }
        }
        if ((a>=0 || b>=0) && (aR>=1 || bR>=1)) {
            System.out.println("Ошибка №1: Невозможно сложить арабские и римские числа");
            System.exit(0);
        } else {
            if (aR>=1 || bR>=1) {
                arb = false;
                a = aR;
                b = bR;
            }
        }
        if (a>10 || a<1 || b>10 || b<1) {
            System.out.println("Ошибка №1: Аргумент(ы) вышел(и) за границу диапозона");
            System.exit(0);
        }
        switch (sign) {
            case 1:
                a = a + b;
                break;
            case 2:
                a = a - b;
                break;
            case 3:
                a = a * b;
                break;
            case 4:
                a = a / b;
                break;
            default: System.out.println("Ошибка №3: Вырожение без оператора");
                System.exit(0);
        }
        if (arb) {
            result = String.valueOf(a);
        } else {
            while (a>0) {
                if (a % 100 == 0) {
                    result = "C";
                    a = 0;
                } else if (a / 90 >= 1) {
                    result = result + "XC";
                    a = a - 90;
                } else if (a / 50 >= 1) {
                    result = result + "L";
                    a = a - 50;
                } else if (a / 40 >= 1) {
                    result = result + "XL";
                    a = a - 40;
                } else if (a / 10 >= 1) {
                    result = result + "X";
                    a = a - 10;
                } else if (a / 9 >= 1) {
                    result = result + "IX";
                    a = a - 9;
                } else if (a / 5 >= 1) {
                    result = result + "V";
                    a = a - 5;
                } else if (a / 4 >= 1) {
                    result = result + "IV";
                    a = a - 4;
                } else if (a / 1 >= 1) {
                    result = result + "I";
                    a = a - 1;
                }
            }
        }
        return result;
    }
}