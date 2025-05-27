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

    public static void main(String[] args) {
        List<Asset> assets = List.of(
            new Asset(AssetType.BOND, 1000),
            new Asset(AssetType.STOCK, 1500),
            new Asset(AssetType.BOND, 2000),
            new Asset(AssetType.STOCK, 2500)
        );

        // Total all assets
        System.out.println("Total Asset Values: " + totalAssetValues(assets, asset -> true));

        // Total bonds only
        System.out.println("Total Bond Values: " + totalAssetValues(assets, asset -> asset.getType() == AssetType.BOND));

        // Total stocks only
        System.out.println("Total Stock Values: " + totalAssetValues(assets, asset -> asset.getType() == AssetType.STOCK));
    }
}
