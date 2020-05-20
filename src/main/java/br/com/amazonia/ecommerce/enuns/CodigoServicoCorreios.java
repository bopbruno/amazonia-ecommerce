package br.com.amazonia.ecommerce.enuns;

public enum CodigoServicoCorreios {

	PAC_sem_contrato_04510 ("04510"),
	PAC_com_contrato_41068 ("41068"),
	PAC_com_contrato_04669 ("04669"),
	PAC_para_grandes_formatos_41300 ("41300"),
	SEDEX_sem_contrato_04014 ("04014"),
	SEDEX_a_Cobrar_sem_contrato_40045 ("40045"),
	SEDEX_a_Cobrar_com_contrato_40126 ("40126"),
	SEDEX_10_sem_contrato_40215 ("40215"),
	SEDEX_Hoje_sem_contrato_40290 ("40290"),
	SEDEX_com_contrato_40096 ("40096"),
	SEDEX_com_contrato_40436 ("40436"),
	SEDEX_com_contrato_40444 ("40444"),
	SEDEX_com_contrato_40568 ("40568"),
	SEDEX_com_contrato_40606 ("40606"),
	SEDEX_com_contrato_04162 ("04162"),
	E_SEDEX_com_contrato_81019 ("81019"),
	E_SEDEX_Prioritário_com_contrato_81027 ("81027"),
	E_SEDEX_Express_com_contrato_81035 ("81035"),
	Grupo_1_e_SEDEX_com_contrato_81868 ("81868"),
	Grupo_2_e_SEDEX_com_contrato_81833 ("81833"),
	Grupo_3_e_SEDEX_com_contrato_81850 ("81850");
	
	private String descricao;
    
    private CodigoServicoCorreios(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
