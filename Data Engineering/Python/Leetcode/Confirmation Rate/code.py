
import pandas as pd

signups_data = [
    [3, '2020-03-21 10:16:13'],
    [7, '2020-01-04 13:57:59'],
    [2, '2020-07-29 23:09:44'],
    [6, '2020-12-09 10:39:37']]

signups = (pd.DataFrame(signups_data, columns=['user_id', 'time_stamp'])
           .astype({'user_id':'Int64', 'time_stamp':'datetime64[ns]'}))

confirmations_data = [
    [3, '2021-01-06 03:30:46', 'timeout'],
    [3, '2021-07-14 14:00:00', 'timeout'],
    [7, '2021-06-12 11:57:29', 'confirmed'],
    [7, '2021-06-13 12:58:28', 'confirmed'],
    [7, '2021-06-14 13:59:27', 'confirmed'],
    [2, '2021-01-22 00:00:00', 'confirmed'],
    [2, '2021-02-28 23:59:59', 'timeout']]

confirmations = (pd.DataFrame(confirmations_data, columns=['user_id', 'time_stamp', 'action'])
                 .astype({'user_id':'Int64', 'time_stamp':'datetime64[ns]', 'action':'object'}))

# Step 1: Count "confirmed" actions and total requests for each user.
total_requests_count = confirmations.groupby('user_id').size().reset_index(name="total_requests_count")
confirmed_requests_count = confirmations[confirmations['action']=='confirmed'].groupby('user_id').size().reset_index(name="confirmed_requests_count")
requests_count_details = pd.merge(total_requests_count, confirmed_requests_count, how="left", on="user_id")

# Step 2: Merge counts with Signups DataFrame to include all users
result = pd.merge(signups[['user_id']], requests_count_details, how="left", on="user_id").fillna(0)

# Step 3: Calculate confirmation rate
result['confirmation_rate'] = result['confirmed_requests_count'] / result['total_requests_count']
result['confirmation_rate'] = result['confirmation_rate'].fillna(0).round(2)

# Final result
print(result[['user_id', 'confirmation_rate']])

