package dto;

import lombok.*;

// Класс для построения запросов с данными пользователя
@Setter@Getter@AllArgsConstructor@NoArgsConstructor@Builder
public class ValidUserRequest {
    // Полное имя (Фамилия,Имя)
    private String full_name;
    // Электронный адрес
    private String email;
    // Пароль
    private String password;
    private boolean generate_magic_link;
}
