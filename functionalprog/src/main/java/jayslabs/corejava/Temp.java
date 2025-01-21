package jayslabs.corejava;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Temp {

    public static void main(String[] args) {
        System.out.println(userTypeToEditPermission());
    }

    static Map<String, Boolean> userTypeToEditPermission(){
        return Stream.of(UserType.values())
                .collect(Collectors.toMap(Enum::name, UserType::hasEditPermission));
    }

}



enum UserType {
    ADMIN(true), MODERATOR(true), DEVELOPER(false);

    private final boolean editPermission;

    UserType(boolean editPermission) {
        this.editPermission = editPermission;
    }

    public boolean hasEditPermission() {
        return editPermission;
    }
}
