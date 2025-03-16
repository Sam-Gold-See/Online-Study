package com.study.dto.clientuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientUserUpdateDTO {

    // 用户名
    private String name;

    // 用户性别（M：男，女：F）
    private Character gender;
}
