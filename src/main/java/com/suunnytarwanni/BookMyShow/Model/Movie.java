package com.suunnytarwanni.BookMyShow.Model;


import com.suunnytarwanni.BookMyShow.Model.Constant.Language;
import com.suunnytarwanni.BookMyShow.Model.Constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;
}
