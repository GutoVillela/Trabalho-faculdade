package BLL;

public class Validacao {

    public boolean ValidarCPF(String documento) {
        int[] CPF = new int[11];//VARIÁVEL PARA RECEBER CPF
        int dig1, dig2;//VARIÁVEIS PARA RECEBER OS DÍGITOS PARA VALIDAÇÃO

        //LAÇO PARA ARMAZENAR OS DÍGITOS SEPARADAMENTE NO VETOR
        for (int i = 0; i < 11; i++) {
            CPF[i] = Integer.valueOf(documento.substring(i, 1) );
            
        }

        //PRIMEIRO DÍGITO
        int soma = CPF[0] * 10 + CPF[1] * 9 + CPF[2] * 8 + CPF[3] * 7 + CPF[4] * 6 + CPF[5] * 5 + CPF[6] * 4 + CPF[7] * 3 + CPF[8] * 2;
        int resto = soma % 11;

        if (resto < 2) {
            dig1 = 0;
        } else {
            dig1 = 11 - resto;
        }

        //SEGUNDO DÍGITO
        int soma2 = CPF[0] * 11 + CPF[1] * 10 + CPF[2] * 9 + CPF[3] * 8 + CPF[4] * 7 + CPF[5] * 6 + CPF[6] * 5 + CPF[7] * 4 + CPF[8] * 3 + CPF[9] * 2;
        int resto2 = soma2 % 11;

        if (resto2 < 2) {
            dig2 = 0;
        } else {
            dig2 = 11 - resto2;
        }

        if (dig1 == CPF[9] && dig2 == CPF[10] && documento.length() == 11 && documento != "00000000000" && documento != "11111111111" && documento != "22222222222" && documento != "33333333333" && documento != "44444444444" && documento != "55555555555" && documento != "66666666666" && documento != "77777777777" && documento != "88888888888" && documento != "99999999999") {
            return true;
        } else {
            return false;
        }
    }

}


