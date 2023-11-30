package br.com.controleinvestimentos.dtos;

public record GanhosResponseDto(String descricao) {
    public GanhosResponseDto(String descricao) {
        this.descricao = descricao;
    }

}
