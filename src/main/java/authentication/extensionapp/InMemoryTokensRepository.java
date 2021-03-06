package authentication.extensionapp;

import model.AppAuthResponse;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTokensRepository implements TokensRepository {

  private final Map<String, AppAuthResponse> tokens = new ConcurrentHashMap<>();

  @Override
  public AppAuthResponse save(AppAuthResponse appAuthResponse) {
    tokens.put(appAuthResponse.getAppToken(), appAuthResponse);
    return appAuthResponse;
  }

  @Override
  public Optional<AppAuthResponse> get(String appToken) {
    return Optional.of(tokens.get(appToken));
  }

}
