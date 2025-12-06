let SendOtp = null;

function run(){

const nodemailer = require("nodemailer");

const sendOtp = async (email) => {
  const otp = Math.floor(100000 + Math.random() * 900000); // 6-digit OTP

  const transporter = nodemailer.createTransport({
    service: "gmail", // ✅ Correct key name
    auth: {
      user: "ashishkumar.bcse2024@huroorkee.ac.in", // your Gmail
      pass: "ixzz glud lvpb bgns", // your Gmail App Password
    },
  });

  const mailOptions = {
    from: "ashishkumar.bcse2024@huroorkee.ac.in",
    to: "ashish224444q@gmail.com",
    subject: "Your OTP Code",
    text:` Your OTP is ${otp}`,
  };

  try {
    await transporter.sendMail(mailOptions);
    console.log(`✅ OTP ${otp} sent successfully to ${email}`);
    SendOtp = otp;
  } catch (error) {
    console.error("❌ Error sending OTP:", error);
  }
};

// ✅ You must call the function here:
sendOtp("ashish224444q@gmail.com");

}

run();