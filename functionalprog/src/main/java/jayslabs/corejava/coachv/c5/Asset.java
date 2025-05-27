package jayslabs.corejava.coachv.c5;

import java.util.List;
import java.util.function.Predicate;

public class Asset {
    public enum AssetType { BOND, STOCK };
    private final AssetType type;
    private final int value;

    public Asset(AssetType type, int value) {
        this.type = type;
        this.value = value;
    }

    public AssetType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public static int totalAssetValues(final List<Asset> assets,
                                       final Predicate<Asset> assetSelector) {
        return assets.stream()
            .filter(assetSelector)
            .mapToInt(Asset::getValue)
            .sum();
    }
}
