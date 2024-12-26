package umc.spring.web.dto;

import com.querydsl.core.annotations.QueryProjection;

public class MemberDto {
    private String name;
    private String email;

    private String address;
    private int point;


    @QueryProjection
    public MemberDto(String name, String email, String address, int point) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.point = point;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", point=" + point +
                '}';
    }
}
