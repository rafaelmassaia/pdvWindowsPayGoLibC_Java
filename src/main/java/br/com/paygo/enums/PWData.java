package br.com.paygo.enums;

/**
 * Códigos de Informações que podem ser solicitadas
 */
public enum PWData {
    MENU(1),   // menu de opções
    TYPED(2),   // entrada digitada
    CARDINF(3),   // dados de cartão
    PPENTRY(5),   // entrada digitada no PIN-pad
    PPENCPIN(6),   // senha criptografada
    CARDOFF(9),   // processamento off-line de cartão com chip
    CARDONL(10),  // processamento on-line de cartão com chip
    PPCONF(11),  // confirmação de informação no PIN-pad
    BARCODE(12),  // Código de barras, lido ou digitado
    PPREMCRD(13),  // Remoção do cartão do PIN-pad.
    PPGENCMD(14),  // comando proprietário da rede no PIN-pad.
    PPDATAPOSCNF(16),  // confirmação positiva de dados no PIN-pad.
    USERAUTH(17);  // validação da senha.

    private final int value;

    PWData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}