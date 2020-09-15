package com.radix.regression;

import com.radix.test.utils.TokenUtilities;
import com.radixdlt.client.application.RadixApplicationAPI;
import com.radixdlt.client.application.identity.RadixIdentities;
import com.radixdlt.client.core.RadixEnv;
import org.junit.Test;

public class MultipleMessagesWithSameDataTest {
	@Test
	public void given_an_account_owner_who_created_a_token__when_the_owner_mints_max_then_burns_max_then_mints_max__then_it_should_all_be_successful() throws Exception {
		RadixApplicationAPI api = RadixApplicationAPI.create(RadixEnv.getBootstrapConfig(), RadixIdentities.createNew());
		TokenUtilities.requestTokensFor(api);
		byte[] messageBytes = "Hi!".getBytes();
		RadixApplicationAPI.Result result0 = api.sendMessage(messageBytes, false);
		result0.toObservable().subscribe(System.out::println);
		result0.blockUntilComplete();

		RadixApplicationAPI.Result result1 = api.sendMessage(messageBytes, false);
		result1.toObservable().subscribe(System.out::println);
		result1.blockUntilComplete();
	}
}
