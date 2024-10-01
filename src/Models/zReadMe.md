## 1. Mô hình Flight
   **Vai trò**: Đại diện cho chuyến bay cụ thể, bao gồm thông tin như ID chuyến bay, điểm đi, điểm đến, thời gian khởi hành, thời gian đến, và ma trận chỗ ngồi.
   
**Chức năng**:
   - Quản lý trạng thái của chỗ ngồi (có thể đặt hoặc đã đặt).
   - Cung cấp thông tin về chuyến bay cho các đối tượng khác, chẳng hạn như Reservation hoặc User.
   - Cung cấp phương thức để đặt và giải phóng chỗ ngồi.
## 2. Mô hình Passenger
**Vai trò**: Đại diện cho hành khách sử dụng dịch vụ đặt vé.
   
**Chức năng**: 
- Lưu trữ thông tin cá nhân của hành khách như tên, số điện thoại, email, v.v.
- Được sử dụng trong các mô hình khác như Reservation và Ticket để liên kết thông tin đặt chỗ và vé với hành khách cụ thể.
## 3. Mô hình User
   **Vai trò**: Đại diện cho người dùng của hệ thống, có thể là hành khách hoặc quản trị viên.

   **Chức năng**:
   - Quản lý thông tin tài khoản người dùng như tài khoản, mật khẩu, và danh sách vé mà người dùng đã đặt.
   - Cung cấp phương thức để xác thực người dùng, thêm vé, và hủy vé.
   Kết nối với Passenger để lưu trữ thông tin cá nhân và kết nối với Ticket để quản lý vé của người dùng.
## 4. Mô hình Reservation
   **Vai trò**: Đại diện cho việc đặt chỗ cho một hành khách cụ thể trên một chuyến bay.

   **Chức năng**:
   - Lưu trữ thông tin liên quan đến đặt chỗ, bao gồm hành khách, chuyến bay, và trạng thái đặt chỗ.
   - Cung cấp phương thức để xác nhận và hủy đặt chỗ, qua đó cập nhật trạng thái của vé (Ticket) và ghế ngồi trong chuyến bay (Flight).
## 5. Mô hình Ticket
   **Vai trò**: Đại diện cho vé máy bay được cấp cho hành khách sau khi đặt chỗ.

   **Chức năng**:
   - Lưu trữ thông tin liên quan đến vé như ID vé, hành khách, chuyến bay, ghế, và giá vé.
   - Cung cấp phương thức để hiển thị thông tin vé và có thể thêm chức năng để hủy vé khi cần.